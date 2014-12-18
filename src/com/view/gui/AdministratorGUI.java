package com.view.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AdministratorGUI extends JInternalFrame{
	private JTabbedPane pane;
	private JTextField nameField,infoField,nameField2,passwordField2;
	private JButton sortbtn,modbtn,addbtn;
	private JComboBox<String> box,box2,box3;
	private String type,type2,type3;
	private String[]typeList = {"系统管理员","库存管理员","进销人员","财务人员","总经理"};
	
	public AdministratorGUI(){
		super("用户管理", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
		
		this.setVisible(true);
	}

	private JTabbedPane createTabbedPane() {
		// TODO Auto-generated method stub
		pane = new JTabbedPane();
		
		
		nameField = new JTextField(10);
		infoField = new JTextField(20);
		nameField2 = new JTextField(10);
		passwordField2 = new JTextField(10);
		sortbtn = new JButton("搜索");
		modbtn = new JButton("修改");
		addbtn = new JButton("添加");
		box = new JComboBox<String>();
		box.addItem("最高权限");
		box.addItem("取消最高权限");
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
		for(int i =0;i<typeList.length;i++){
			box2.addItem(typeList[i]);
		}
		box2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					type2 = (String)box2.getSelectedItem();
				}
			}
		});
		box3 = new JComboBox<String>();
		box3.addItem("最高权限");
		box3.addItem("取消最高权限");
		box3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					type3 = (String)box3.getSelectedItem();
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
		JPanel jp11 = new JPanel();
		JLabel jl1 = new JLabel("用户名");
		JLabel jl2 = new JLabel("密码");
		jp1.add(jl1);
		jp1.add(nameField2);
		jp11.add(jl2);
		jp11.add(passwordField2);
		
		JPanel jp2 = new JPanel();
		JLabel jl3 = new JLabel("选择角色：");
		jp2.add(jl3);
		jp2.add(box2);
		jp2.add(box3);
		
		JPanel jp3 = new JPanel();
		jp3.add(addbtn);
		
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		jp.add(jp1);
		jp.add(jp11);
		jp.add(jp2);
		jp.add(jp3);
		
		pane.add("添加用户",jp);
		
	}
	
	private void modPane(JTabbedPane pane){
		JPanel jp= new JPanel();
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("输入id：");
		jp1.add(jl1);
		jp1.add(nameField);
		jp1.add(sortbtn);
		
		JPanel jp2 = new JPanel();
		jp2.add(infoField);
		
		JPanel jp3 = new JPanel();
		jp3.add(box);
		
		JPanel jp4 = new JPanel();
		jp4.add(modbtn);
		
		jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		jp.add(jp4);
		
		pane.add("修改用户",jp);
	}
	
	public void addAdministratorListeners(ActionListener[]a){
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
	
	public String getType3(){
		return type3;
	}
}
