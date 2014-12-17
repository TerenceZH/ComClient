package com.view.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.omg.CORBA.StringHolder;

public class CustomerGUI extends JInternalFrame{
	
	private JTextField nameField,phoneField,addressField,zipField,mailField,maxField;
	private JTextField idField2,phoneField2,addressField2,zipField2,mailField2,maxField2;
	private JComboBox<String> box;
	private JButton addButton,sortButton,modButton;
	private JTabbedPane tabbedPane;
	private String type;
	
	public CustomerGUI(){
		super("客户信息管理", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
	}

	private JTabbedPane createTabbedPane(){
		tabbedPane = new JTabbedPane();
		
		addPane(tabbedPane);
		modPane(tabbedPane);
		
		return tabbedPane;
	}
	
	private void addPane(JTabbedPane p){
		nameField = new JTextField(10);
		phoneField = new JTextField(10);
		addressField = new JTextField(10);
		zipField = new JTextField(10);
		mailField = new JTextField(10);
		maxField = new JTextField(5);
		box = new JComboBox<String>();
		box.addItem("进货商");
		box.addItem("销售商");
		box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					type = (String)box.getSelectedItem();
				}
			}
		});
		addButton = new JButton("添加");
		
		JPanel jPanel =new JPanel();
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("名称：");
		JLabel jl2 = new JLabel("电话：");
		jp1.add(jl1);
		jp1.add(nameField);
		jp1.add(jl2);
		jp1.add(phoneField);
		
		JPanel jp2 = new JPanel();
		JLabel jl3 = new JLabel("地址：");
		JLabel jl4 = new JLabel("邮编：");
		jp2.add(jl3);
		jp2.add(addressField);
		jp2.add(jl4);
		jp2.add(zipField);
		
		JPanel jp3 = new JPanel();
		JLabel jl5 = new JLabel("邮箱：");
		JLabel jl6 = new JLabel("最大额度：");
		jp3.add(jl5);
		jp3.add(mailField);
		jp3.add(jl6);
		jp3.add(maxField);
		
		JPanel jp4 = new JPanel();
		jp4.add(addButton);
		
		jPanel.add(jp1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		jPanel.add(jp4);
		
		p.add("添加客户",jPanel);
	}
	
	private void modPane(JTabbedPane p){
		idField2 = new JTextField(10);
		phoneField2 = new JTextField(10);
		addressField2 = new JTextField(10);
		zipField2 = new JTextField(10);
		mailField2 = new JTextField(10);
		maxField2 = new JTextField(5);
		sortButton = new JButton("搜索");
		modButton = new JButton("修改");
		
		JPanel jp = new JPanel();
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("编号：");
		jp1.add(jl1);
		jp1.add(idField2);
		jp1.add(sortButton);
		
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("电话：");
		JLabel jl3 = new JLabel("地址：");
		jp2.add(jl2);
		jp2.add(phoneField2);
		jp2.add(jl3);
		jp2.add(addressField2);
		
		JPanel jp3 = new JPanel();
		JLabel jl4 = new JLabel("邮编：");
		JLabel jl5 = new JLabel("邮箱：");
		jp3.add(jl4);
		jp3.add(zipField2);
		jp3.add(jl5);
		jp3.add(mailField2);
		
		JPanel jp4 = new JPanel();
		JLabel jl6 = new JLabel("最大额度：");
		jp4.add(jl6);
		jp4.add(maxField2);
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		jp.add(jp4);
		
		p.add("修改客户",jp);
	}
	
	public void addCustomerListeners(ActionListener[]a){
		if(a.length!=3){
			return;
		}
		addButton.addActionListener(a[0]);
		sortButton.addActionListener(a[1]);
		modButton.addActionListener(a[2]);
	}
	
	public String getName(){
		return nameField.getText().trim();
	}
	
	
	public String getPhone(){
		return phoneField.getText().trim();
	}
	
	public String getAddress(){
		return addressField.getText().trim();
	}
	
	public String getZip(){
		return zipField.getText().trim();
	}
	
	public String getMail(){
		return mailField.getText().trim();
	}
	
	public String getMax(){
		return maxField.getText().trim();
	}
	
	public String getId2(){
		return idField2.getText().trim();
	}
	
	public String getPhone2(){
		return phoneField2.getText().trim();
	}
	
	public String getAddress2(){
		return addressField2.getText().trim();
	}
	
	public String getZip2(){
		return zipField2.getText().trim();
	}
	
	public String getMail2(){
		return mailField2.getText().trim();
	}
	
	public String getMax2(){
		return maxField2.getText().trim();
	}
	
	public String getType(){
		return type;
	}
	
	public void setText(String s1,String s2,String s3,String s4,String s5){
		phoneField2.setText(s1);
		addressField2.setText(s2);
		zipField2.setText(s3);
		mailField2.setText(s4);
		maxField2.setText(s5);
	}
	
}
