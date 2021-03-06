package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.func.MessageDialog;
import com.model.User;
import com.remote_interface.IUserService;
import com.view.gui.LoginGUI;
import com.view.vinterface.LoginView;

public class LoginViewImpl implements LoginView{
	private transient LoginGUI gui;
	private IUserService service;

	
	public LoginViewImpl(IUserService s)throws Exception{
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
			
			login(username, password);
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


	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if(username.length()==0){
			MessageDialog.tip("请输入用户名");
		}else if (password.length()==0) {
			MessageDialog.tip("请输入密码");
		}else {
			try{
				User u = service.getUser(username, password);
				if(u==null){
					MessageDialog.tip("用户名、密码不匹配，请重新输入！");
				}else{
					gui.close();
					getMainView(service.getUser(username, password));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}


	@Override
	public void getMainView(User user) {
		// TODO Auto-generated method stub
		 try {
			new MainViewImpl(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
