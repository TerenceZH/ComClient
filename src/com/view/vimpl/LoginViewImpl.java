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
				MessageDialog.tip("�������û���");
			}else if (password.length()==0) {
				MessageDialog.tip("����������");
			}else {
				try{
					Power temp = service.login(username, password);
					if(temp==null){
						MessageDialog.tip("�û��������벻ƥ�䣬���������룡");
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
