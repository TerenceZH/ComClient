package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.func.MessageDialog;
import com.remote_interface.IUserService;
import com.view.gui.ChangePasswordGUI;
import com.view.vinterface.ChangePasswordView;

public class ChangePasswordViewImpl implements ChangePasswordView{
	private IUserService serivce;
	private ChangePasswordGUI gui;
	
	/*public ChangePasswordViewImpl(IUserSerivce s)throws Exception{
		gui = new ChangePasswordGUI();
		gui.addChangePasswordListener(confirmHandler);
		
		serivce = s;
	}*/
	
	public ChangePasswordViewImpl(){
		gui = new ChangePasswordGUI();
		gui.addChangePasswordListener(confirmHandler);
		
	}
	
	
	transient ActionListener confirmHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String old = gui.getOldPwd();
			String new1 = gui.getNewPwd();
			String new2 = gui.getNewPwd2();
			
			handlerCHangePwd(old, new1, new2);
		}
	};

	@Override
	public void handlerCHangePwd(String old, String new1, String new2) {
		// TODO Auto-generated method stub
		if(old.length()==0||new1.length()==0||new2.length()==0){
			MessageDialog.tip("不能为空！");
		}else{
			if(!MainViewImpl.user.getPassword().equals(old)){
				MessageDialog.tip("旧密码输入错误，请重新验证");
			}else {
				if(new1.equals(old)){
					MessageDialog.tip("新密码不能和旧密码相同");
				}else {
					try {
						serivce.modifyPassword(MainViewImpl.user, new1);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}

	@Override
	public JInternalFrame getChangePasswordView() {
		// TODO Auto-generated method stub
		return gui;
	}
	

}
