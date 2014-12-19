package com.view.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ImportViewGUI extends JInternalFrame{
	private JTabbedPane pane;
	private JTextField customerField,warehouseField,operatorField,descField,totalField;
	private JTextArea list;
	private JButton addItemButton,addButton,getCancelableButton,getNextButton,addCancelButton;
	private JTextField idField,customerField2,timeField,descField2,totalField2;
	private ArrayList<String> commodityList = new ArrayList<String>();
	private ItemFrame frame;
	
	
	public ImportViewGUI(){
		super("进货单", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
		this.setVisible(true);
		frame = new ItemFrame();
		frame.setVisible(false);
	}

	private JTabbedPane createTabbedPane() {
		// TODO Auto-generated method stub
		pane = new JTabbedPane();
		addImportPanel( pane);
		addCancelImportPanel( pane);
		
		return pane;
	}
	
	private void addImportPanel(JTabbedPane pane){
		JPanel jp = new JPanel();
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("客户：");
		customerField = new JTextField(10);
		jp1.add(jl1);
		jp1.add(customerField);
		
		JPanel jp3 = new JPanel();
		JLabel jl3 = new JLabel("仓库：");
		JLabel jl4 = new JLabel("操作员：");
		warehouseField = new JTextField(10);
		operatorField = new JTextField(10);
		jp3.add(jl3);
		jp3.add(warehouseField);
		jp3.add(jl4);
		jp3.add(operatorField);
		
		
		JPanel jp4 = new JPanel();
		JLabel jl7 = new JLabel("总额：");
		addItemButton = new JButton("点击添加商品");
		totalField = new JTextField(10);
		jp4.add(jl7);
		jp4.add(totalField);
		jp4.add(addItemButton);
		
		JPanel jjJPanel = new JPanel();
		list = new JTextArea(5,20);
		jjJPanel.add(list);
		
		JPanel jp5 = new JPanel();
		JLabel jl6 = new JLabel("备注");
		descField = new JTextField(15);;
		jp5.add(jl6);
		jp5.add(descField);
		
		JPanel jp6 = new JPanel();
		addButton = new JButton("添加");
		jp6.add(addButton);
		
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(jp1);
		jp.add(jp3);
		jp.add(jp4);
		jp.add(jjJPanel);
		jp.add(jp5);
		jp.add(jp6);
		
		pane.add("添加进货单",jp);
		
	}
	
	private void addCancelImportPanel(JTabbedPane pane){
		JPanel jp = new JPanel();
		
		JPanel jp1 = new JPanel();
		getCancelableButton= new JButton("获取可退货的单子");
		jp1.add(getCancelableButton);
		getNextButton = new JButton("下一个");
		jp1.add(getNextButton);
		
		JPanel jp2 = new JPanel();
		idField = new JTextField(10);
		customerField2 = new JTextField(10);
		timeField = new JTextField(10);
		descField2 = new JTextField(15);
		totalField2 = new JTextField(10);
		idField.setEditable(false);
		customerField2.setEditable(false);
		timeField.setEditable(false);
		totalField2.setEditable(false);
		JLabel jl1 = new JLabel("编号：");
		JLabel jl2 = new JLabel("客户：");
		JLabel jl3 = new JLabel("时间：");
		JLabel jl4 = new JLabel("备注：");
//		JLabel jl5 = new JLabel("总额：");
		addCancelButton = new JButton("生成退货单");
		jp2.add(jl1);
		jp2.add(idField);
		jp2.add(jl2);
		jp2.add(customerField2);
		
		JPanel jp3 = new JPanel();
		jp3.add(jl3);
		jp3.add(timeField);
//		jp3.add(jl5);
//		jp3.add(totalField2);
		
//		JPanel jp4 = new JPanel();
		jp3.add(jl4);
		jp3.add(descField2);
		
		JPanel jp5 = new JPanel();
		addCancelButton.setEnabled(false);
		jp5.add(addCancelButton);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
//		jp.add(jp4);
		jp.add(jp5);
		
		pane.add("退货单",jp);
	}
	
	//addItemButton,addButton,getCancelableButton,getNextButton,addCancelButton;
	public void addImportListener(ActionListener[]a){
		if(a.length!=5){
			return;
		}
		addItemButton.addActionListener(a[0]);
		addButton.addActionListener(a[1]);
		getCancelableButton.addActionListener(a[2]);
		getNextButton.addActionListener(a[3]);
		addCancelButton.addActionListener(a[4]);
	}
	
	public ItemFrame getFrame(){
		return frame;
	}
	
	
	public String getCustomer(){
		return customerField.getText().trim();
	}
	
	public String getWarehouse(){
		return warehouseField.getText().trim();
	}
	
	public String getOperator(){
		return operatorField.getText().trim();
	}
	
	public String getDesc(){
		return descField.getText().trim();
	}
	
	public void setOperator(String s){
		operatorField.setText(s);
	}
	
	public String getTotal(){
		return totalField.getText();
	}
	
	public void setTotal(String s){
		totalField.setText(s);
	}
	
	public String getDesc2(){
		return descField2.getText().trim();
	}
	
	public void setId(String t){
		idField.setText(t);
	}
	
	//idField,customerField2,timeField,descField2,totalField2;
	public void setCustomer(String s){
		customerField2.setText(s);
	}
	
	public void setTime(String s){
		timeField.setText(s);
	}
	
	public void setDesc(String s){
		descField2.setText(s);
	}
	
	public void setTotal2(String s){
		totalField2.setText(s);
	}
	
	public void addToList(String s){
		list.append(s+"\n");
	}
	
	public void addToCommodityList(String s){
		commodityList.add(s);
	}
	
	public ArrayList<String> getList(){
		return commodityList;
	}
	
	public JButton getCancelButton(){
		return addCancelButton;
	}
	
	
	public class ItemFrame extends JFrame{
		private JTextField noField,priceField,quantityField,totalField,descField;
		private JButton sortButton,confirmButton,cancelButton;
		
		public ItemFrame(){
			super("添加商品列表");
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setBounds(screenSize.width / 20, screenSize.height / 30,
					screenSize.width / 2, screenSize.height / 2);
			
			JPanel jp = new JPanel();
			noField = new JTextField(10);
			priceField  = new JTextField(5);
			quantityField = new JTextField(5);
			totalField  = new JTextField(5);
			sortButton = new JButton("搜索");
			confirmButton = new JButton("确认");
			cancelButton = new JButton("取消");
			descField = new JTextField(10);
			JLabel jl1 = new JLabel("编号：");
			JLabel jl2 = new JLabel("单价：");
			JLabel jl3 = new JLabel("数量：");
			JLabel jl4 = new JLabel("总价：");
			JLabel jl5 = new JLabel("备注");
			JPanel jp1 = new JPanel();
			jp1.add(jl1);
			jp1.add(noField);
			jp1.add(sortButton);
			JPanel jp2 = new JPanel();
			jp2.add(jl2);
			jp2.add(priceField);
			jp2.add(jl3);
			jp2.add(quantityField);
			JPanel jp3 = new JPanel();
			jp3.add(jl4);
			jp3.add(totalField);
			jp3.add(jl5);
			jp3.add(descField);
			JPanel jp4 = new JPanel();
			jp4.add(confirmButton);
			jp4.add(cancelButton);
			
			jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
			jp.add(jp1);
			jp.add(jp2);
			jp.add(jp3);
			jp.add(jp4);
			
			this.getContentPane().add(jp,BorderLayout.CENTER);
		}
		
		
		public void addItemActionListeners(ActionListener []aa){
			if(aa.length!=3){
				return;
			}
			sortButton.addActionListener(aa[0]);
			confirmButton.addActionListener(aa[1]);
			cancelButton.addActionListener(aa[2]);
		}
		
		public String getCommodity(){
			return noField.getText().trim();
		}
		
		public String getPrice(){
			return priceField.getText().trim();
		}
		
		public String getQuantity(){
			return quantityField.getText().trim();
		}
		
		public String getTotal(){
			return totalField.getText().trim();
		}
		
		public String getDesc(){
			return descField.getText().trim();
		}
		
		public void setPrice(String s){
			priceField.setText(s);
		}
		
		public void setTotal(String s){
			totalField.setText(s);
		}
		
		
		public void setNull(){
			noField.setText(null);
			priceField.setText(null);
			quantityField.setText(null);
			confirmButton.setText(null);
			cancelButton.setText(null);
		}
	}
	
}
