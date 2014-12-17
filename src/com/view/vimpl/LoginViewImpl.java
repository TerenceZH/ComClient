package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.func.MessageDialog;
import com.model.Power;
import com.remote_interface.IUserSerivce;
import com.view.gui.LoginGUI;
import com.view.vinterface.LoginView;

public class LoginViewImpl implements LoginView{
	private transient LoginGUI gui;
	private IUserSerivce service;

	
	public LoginViewImpl(IUserSerivce s)throws Exception{
		gui = new LoginGUI();
		gui.addLoginListeners(loginListeners);
		
		service = s;
	}

	
	transient ActionListener submitHandle = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			String username = gui.getUsername();
			String password = gui.getPassword();
			
			if(username.length()==0){
				MessageDialog.tip("请输入用户名");
			}else if (password.length()==0) {
				MessageDialog.tip("请输入密码");
			}else {
				try{
					Power temp = service.login(username, password);
					if(temp==null){
						MessageDialog.tip("用户名、密码不匹配，请重新输入！");
					}else{
						gui.close();
						new MainViewImpl(service.getUser(username, password));
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	};
	
	transient ActionListener resetHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			gui.reset();
		}
	};

	transient ActionListener[] loginListeners = {submitHandle,resetHandler};

}
