package com.view.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AccountGUI extends JInternalFrame{
	private JTabbedPane pane;
	private JTextField nameField,moneyField,noField,nameField2;
	private JButton addButton,sortButton,modButton;
	
	public AccountGUI(){
		super("账户管理", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
		
		this.setVisible(true);
	}
	
	private JTabbedPane createTabbedPane(){
		pane = new JTabbedPane();
		
		addPane(pane);
		modPane(pane);
		
		return pane;
	}
	
	
	private void addPane(JTabbedPane pane){
		JPanel jp = new JPanel();
		
		nameField = new JTextField(10);
		moneyField = new JTextField(10);
		addButton = new JButton("添加");
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("名称：");
		
		jp1.add(jl1);
		jp1.add(nameField);
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("数目：");
		
		jp2.add(jl2);
		jp2.add(moneyField);
		
		JPanel jp3 = new JPanel();
		jp3.add(addButton);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		
		pane.add("添加账户",jp);
	}
	
	private void modPane(JTabbedPane pane){
		JPanel jp = new JPanel();
		
		noField = new JTextField(10);
		nameField2 = new JTextField(10);
		sortButton = new JButton("搜索");
		modButton = new JButton("修改");
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("编号：");
		
		jp1.add(jl1);
		jp1.add(noField);
		JPanel jpp = new JPanel();
		jpp.add(sortButton);
		
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("名称：");
		
		jp2.add(jl2);
		jp2.add(nameField2);
		
		JPanel jp3 = new JPanel();
		jp3.add(modButton);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(jp1);
		jp.add(jpp);
		jp.add(jp2);
		jp.add(jp3);
		
		pane.add("修改账户",jp);
	}
	
	
	
	public void addAccountListeners(ActionListener a[]){
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
	
	public String getMoney(){
		return moneyField.getText().trim();
	}

	public String getNo(){
		return noField.getText().trim();
	}
	
	public String getName2(){
		return nameField2.getText().trim();
	}
	
	public void setName(String s){
		nameField2.setText(s);
	}

}
