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

public class UserGUI extends JInternalFrame{
	private JTextField nameField,infoField,nameField2,passwordField2;
	private JButton sortbtn,modbtn,addbtn;
	private JTabbedPane pane;
	private JComboBox<String> box,box2;
	private String type,type2;
	private String[]typeList = {"系统管理员","库存管理员","进销人员","财务人员","总经理"};
	
	public UserGUI(){
		super("用户管理", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
	}

	private JTabbedPane createTabbedPane() {
		// TODO Auto-generated method stub
		pane = new JTabbedPane();
		
		
		nameField = new JTextField(10);
		infoField = new JTextField(15);
		nameField2 = new JTextField(10);
		passwordField2 = new JTextField(10);
		sortbtn = new JButton("搜索");
		modbtn = new JButton("修改");
		addbtn = new JButton("添加");
		box = new JComboBox();
		box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					type = (String)box.getSelectedItem();
				}
			}
		});
		box2 = new JComboBox<String>();
		box2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					type2 = (String)box2.getSelectedItem();
				}
			}
		});
		
		
		addPane(pane);
		modPane(pane);
		
		
		return pane;
	}

	private void addPane(JTabbedPane pane){
		JPanel jp = new JPanel();
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("用户名");
		JLabel jl2 = new JLabel("密码");
		jp1.add(jl1);
		jp1.add(jl2);
		
		JPanel jp2 = new JPanel();
		JLabel jl3 = new JLabel("选择角色：");
		jp2.add(jl3);
		for(int i =0;i<typeList.length;i++){
			box2.addItem(typeList[i]);
		}
		jp2.add(box2);
		
		JPanel jp3 = new JPanel();
		jp3.add(addbtn);
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		
		pane.add("添加用户",jp);
		
	}
	
	private void modPane(JTabbedPane pane){
		JPanel jp= new JPanel();
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("输入用户名：");
		jp1.add(jl1);
		jp1.add(nameField);
		jp1.add(sortbtn);
		
		JPanel jp2 = new JPanel();
		jp2.add(infoField);
		
		JPanel jp3 = new JPanel();
		for(int i =0;i<typeList.length;i++){
			box.addItem(typeList[i]);
		}
		jp3.add(box);
		jp3.add(modbtn);
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		
		pane.add("修改商品",jp);
	}
	
	public void addUserListeners(ActionListener[]a){
		if(a.length!=3){
			return;
		}
		sortbtn.addActionListener(a[0]);
		modbtn.addActionListener(a[1]);
		addbtn.addActionListener(a[2]);
	}
	
	public String getName(){
		return nameField.getText().trim();
	}
	
	public void setInfo(String s){
		infoField.setText(s);
	}
	
	public String getType(){
		return type;
	}
	
	public String getName2(){
		return nameField2.getText().trim();
	}
	
	public String getPassword(){
		return passwordField2.getText().trim();
	}
	
	public String getType2(){
		return type2;
	}
}
