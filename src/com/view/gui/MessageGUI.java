package com.view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.model.Message;

public class MessageGUI extends JInternalFrame{
	private MessagePanel panel;
	
	public MessageGUI(){
		super("日志查询",true,true,true,true);
		panel = new MessagePanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width * 2 / 3,
				screenSize.height  *2/ 3);
		this.setContentPane(panel);
	}
	
	public MessagePanel getPanel(){
		return panel;
	}
	
	public class MessagePanel extends JPanel{
		private JTable table;	
		private MyTableModel tableModel;
		private JButton button,button2;
		
		public MessagePanel(){
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
		
		public JPanel search(){
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());

			button = new JButton("刷新");
			panel.add(button);
			button2 = new JButton("显示未读");
			panel.add(button2);

			return panel;
		}
		
		public void addMessageListeners(ActionListener []a){
			if(a.length!=2){
				return;
			}
			button.addActionListener(a[0]);
			button2.addActionListener(a[1]);
		}
		

		 public class MyTableModel extends AbstractTableModel{
			ArrayList<Message> messages = new ArrayList<Message>();
			
	//		private String[] columnNames ={"发件人","时间",""};
			private String[] columnNames = {"发件人","时间","内容"};
			

			public int getColumnCount(){
				return columnNames.length;
			}

			public int getRowCount(){
				return messages.size();
			}

			public String getColumnName(int col){
				return columnNames[col];
			}

			public Object getValueAt(int row, int col){
				Message m = messages.get(row);
				Object o =  m.getMessageValue(col);
				
				return o;
			}

			@SuppressWarnings("unchecked")
			public Class getColumnClass(int c){
				return getValueAt(0, c).getClass();
			}

			public boolean isCellEditable(int row, int col){
				return false;
			}

			public void updateData(ArrayList<Message> messages){
				this.messages = messages;
				if(messages.size()==0){
					messages = new ArrayList<Message>();
				}else {
					fireTableRowsInserted(0, messages.size()-1);
				}
			}
		 }
	}
}
	