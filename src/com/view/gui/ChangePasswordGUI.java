package com.view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangePasswordGUI extends JInternalFrame{
	
	private JTextField oldPwd,newPwd,newPwd2;
	private JButton confirmBtn;
	
	public ChangePasswordGUI(){
		super("–ﬁ∏ƒ√‹¬Î", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		pwdLayout();
		this.setVisible(true);
	}

	private void pwdLayout(){
		JPanel jp = new JPanel();
		
		JLabel jl1 = new JLabel("æ…√‹¬Î£∫");
		JLabel jl2 = new JLabel("–¬√‹¬Î£∫");
		JLabel jl3 = new JLabel("–¬√‹¬Î£∫");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		oldPwd = new JTextField(15);
		newPwd = new JTextField(15);
		newPwd2 = new JTextField(15);
		confirmBtn = new JButton("»∑»œ");
		
		jp.add(Box.createVerticalStrut(30));
		jp1.add(jl1);
		jp1.add(oldPwd);
		jp.add(jp1);
		jp2.add(jl2);
		jp2.add(newPwd);
		jp.add(jp2);
		jp3.add(jl3);
		jp3.add(newPwd2);
		jp.add(jp3);
		jp.add(Box.createVerticalStrut(10));
		jp.add(confirmBtn);
		jp.add(Box.createVerticalStrut(30));
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		
		this.getContentPane().add(jp,BorderLayout.CENTER);
	}
	
	public void addChangePasswordListener(ActionListener a){
		confirmBtn.addActionListener(a);
	}
	
	public String getOldPwd(){
		return oldPwd.getText().trim();
	}
	
	public String getNewPwd(){
		return newPwd.getText().trim();
	}
	
	public String getNewPwd2(){
		return newPwd2.getText().trim();
	}
}
