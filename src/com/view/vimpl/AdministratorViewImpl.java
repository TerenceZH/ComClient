package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.func.MessageDialog;
import com.model.User;
import com.remote_interface.IUserSerivce;
import com.view.gui.AdministratorGUI;
import com.view.vinterface.AdministratorView;

public class AdministratorViewImpl implements AdministratorView{
	private IUserSerivce service;
	private AdministratorGUI gui;
	
	/*public AdministratorViewImpl(IUserSerivce s) throws Exception{
		gui = new AdministratorGUI();
		gui.addAdministratorListeners(handlers);
		
		service  = s;
	}*/
	
	public AdministratorViewImpl(){
		gui = new AdministratorGUI();
		gui.addAdministratorListeners(handlers);
	}
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = gui.getName2();
			String password = gui.getPassword();
			String type = gui.getType2();
			String authority = gui.getType3();
			
			int typeInt = getType(type);
			int auth = getAuth(authority);
			
			handleAddUser(name, password, typeInt,auth);
		}
	};
	
	transient ActionListener sortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = gui.getName();
			
			handleSortUser(name);
		}
	};
	
	transient ActionListener modHandler  = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	ActionListener [] handlers = {sortHandler,modHandler,addHandler};

	@Override
	public JInternalFrame getAdministratorView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleModifyUser() {
		// TODO Auto-generated method stub
		String name = gui.getName();
		String auth = gui.getType();
		
		if(name.length()==0){
			MessageDialog.tip("请输入用户名！");
		}else {
			try {
				service.modUser(name,getAuth(auth));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public void handleSortUser(String name) {
		// TODO Auto-generated method stub
		if(name.length()==0){
			MessageDialog.tip("请输入用户名！");
		}else {
			User u = null;
			try {
				u = service.getUser(name);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String te = u.getGetTopAuthority()==0?"没有":"";
			gui.setInfo("角色："+getType(u.getType())+"  ;"+te+"最高权限");
		}
	}

	@Override
	public void handleAddUser(String name, String pwd, int type, int auth) {
		// TODO Auto-generated method stub
		if(name.length()==0||pwd.length()==0){
			MessageDialog.tip("用户名或者密码不能为空！");
		}else {
			try {
				service.addUser(name, pwd, type, auth);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private int getType(String s){
		int t = -1;
		switch (s) {
		case "库存管理员":
			t = 1;
			break;
		case "进销人员":
			t = 2;
			break;
		case "财务人员":
			t = 3;
			break;
		case "总经理":
			t = 4;
			break;
		case "系统管理员":
			t = 0;
			break;
		default:
			break;
		}
		return t;
	}
	
	private  String getType(int t){
		String s = "";
		switch (t) {
		case 0:
			s = "系统管理员";
			break;
		case 1:
			s = "库存管理员";
			break;
		case 2:
			s = "进销人员";
			break;
		case 3:
			s = "财务人员";
			break;
		case 4:
			s = "总经理";
			break;

		default:
			break;
		}
		return s;
	}
	
	private int getAuth(String s){
		return s.equals("最高权限")?1:0;
	}

}
