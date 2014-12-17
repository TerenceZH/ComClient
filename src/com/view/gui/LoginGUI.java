package com.view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI extends JFrame{
	private JTextField name;
	private JPasswordField password;
	private JButton submit,reset;
	
	/**构造方法 */
	public LoginGUI() {
		super("进销存管理系统");
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width/3,screenSize.height/3,480,350);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		submit=new JButton("确定");		
		reset=new JButton("重置");
		
		loginLayout();
		this.setVisible(true);
	}
	
	public void close(){
		this.setVisible(false);
	}
	
	/**为两个按钮注册监听器 */
	public void addLoginListeners(ActionListener[]a){
		int len = a.length;
		if(len!=2){return;}
		
		submit.addActionListener(a[0]);
		reset.addActionListener(a[1]);
	}
	
	/**创建图形界面*/
	private void loginLayout(){
		JLabel nameLabel;
		JLabel passwordLabel;
		JPanel panel_one, panel_two;
		JLabel label;
		nameLabel = new JLabel("用户名:  ", JLabel.RIGHT);
		nameLabel.setForeground(new Color(0, 128, 255));
		passwordLabel = new JLabel("密码:  ", JLabel.RIGHT);
		passwordLabel.setForeground(new Color(0, 128, 255));
		name = new JTextField();
		name.setColumns(10);
		password = new JPasswordField();
		password.setColumns(10);
		password.setEchoChar('*');
		panel_one = new JPanel();
		panel_one.setLayout(new GridLayout(3, 1));
		panel_two = new JPanel();
		this.setLayout(new BorderLayout());
		this.setContentPane(new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				setDoubleBuffered(true);
				g.drawImage(new ImageIcon(LoginGUI.class.getResource("image/123.jpg"))
						.getImage(), 0, 0, null);
			}
		});
		for (int i = 0; i < 18; i++)
		{
			label = new JLabel();
			label.setPreferredSize(new Dimension(600, 2));
			this.getContentPane().add(label, BorderLayout.NORTH);
		}
		panel_one.add(nameLabel);
		panel_one.add(name);
		panel_one.add(passwordLabel);
		panel_one.add(password);
		label = new JLabel();
		label.setPreferredSize(new Dimension(100, 10));
		panel_two.add(label);
		panel_two.add(submit);
		panel_two.add(reset);
		panel_one.setOpaque(false);
		panel_two.setOpaque(false);
		this.getContentPane().add(panel_one, BorderLayout.EAST);
		this.getContentPane().add(panel_two, BorderLayout.SOUTH);
	}
	
	/**以下都是一些平常函数*/
	public String getUsername(){
		return name.getText().trim();
	}
	
	public String getPassword(){
		return String.valueOf(password.getPassword());
	}
	
	public void reset(){
		name.setText(null);
		password.setText(null);
	}
	


}
