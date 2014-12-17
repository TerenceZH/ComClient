package com.view.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AccountGUI extends JInternalFrame{
	private JTabbedPane pane;
	private JTextField nameField,moneyField;
	private JButton addButton;
	
	public AccountGUI(){
		super("账户管理", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
	}
	
	private JTabbedPane createTabbedPane(){
		pane = new JTabbedPane();
		
		JPanel jp = new JPanel();
		
		nameField = new JTextField(10);
		moneyField = new JTextField(10);
		addButton = new JButton("添加");
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("名称：");
		jp1.add(nameField);
		jp1.add(jl1);
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("数目：");
		jp2.add(moneyField);
		jp2.add(jl2);
		
		JPanel jp3 = new JPanel();
		jp3.add(addButton);
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		
		pane.add("添加账户",jp);
		
		
		return pane;
	}
	
	public void addAccountListeners(ActionListener a){
		addButton.addActionListener(a);
	}
	
	public String getName(){
		return nameField.getText().trim();
	}
	
	public String getMoney(){
		return moneyField.getText().trim();
	}


}
