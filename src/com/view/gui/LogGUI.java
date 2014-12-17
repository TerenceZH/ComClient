package com.view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.model.Log;


public class LogGUI extends JInternalFrame{
	private LogPanel l;
	
	public LogGUI(){
		super("日志查询",true,true,true,true);
		l = new LogPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width * 2 / 3,
				screenSize.height  *2/ 3);
		this.setContentPane(l);
	}
	
	public LogPanel getLogPanel(){
		return l;
	}

	
	public class LogPanel extends JPanel{
		private JTable table;	
		private MyTableModel tableModel;
		private JTextField startTimeField,endTimeField;
		private JButton button,button2;
		
		public LogPanel(){
			super(new BorderLayout());
			JPanel pane = search();
			this.add(pane,BorderLayout.NORTH);
			
			tableModel=new MyTableModel();
			table = new JTable(tableModel);
			
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
			table.setAutoCreateRowSorter(true);

			JScrollPane scrollPane = new JScrollPane(table);
			add(scrollPane,BorderLayout.CENTER);
		}

		public MyTableModel getTable(){
			return tableModel;
		}
		
		public String getStartTime(){
			return startTimeField.getText().trim();
		}
		
		public String getEndTime(){
			return endTimeField.getText().trim();
		}
		
		public void addLogListeners(ActionListener []a){
			if(a.length!=2){
				return;
			}
			button.addActionListener(a[0]);
			button2.addActionListener(a[1]);
		}
		
		public JPanel search(){
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());
			JLabel lable1 = new JLabel("起始时间：");
			JLabel lable2 = new JLabel("结束时间：");
			startTimeField = new JTextField(10);
			endTimeField = new JTextField(10);
			panel.add(lable1);
			panel.add(startTimeField);
			panel.add(lable2);
			panel.add(endTimeField);

			button = new JButton("查询");
			panel.add(button);
			button2 = new JButton("显示全部");
			panel.add(button2);

			return panel;
		}
		

		 public class MyTableModel extends AbstractTableModel{
			ArrayList<Log> logs = new ArrayList<Log>();
			
			private String[] columnNames ={"描述","时间"};
			

			public int getColumnCount(){
				return columnNames.length;
			}

			public int getRowCount(){
				return logs.size();
			}

			public String getColumnName(int col){
				return columnNames[col];
			}

			public Object getValueAt(int row, int col){
				Log log = logs.get(row);
				return log.getLogValue(col);
			}

			@SuppressWarnings("unchecked")
			public Class getColumnClass(int c){
				return getValueAt(0, c).getClass();
			}

			public boolean isCellEditable(int row, int col){
				return false;
			}

			public void updateData(ArrayList<Log>logs){
				this.logs = logs;
				if(logs.size()==0){
					logs = new ArrayList<Log>();
				}else {
					fireTableRowsInserted(0, logs.size()-1);
				}
			}
		}
	}
}
