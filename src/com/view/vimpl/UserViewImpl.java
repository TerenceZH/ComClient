package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import com.func.MessageDialog;
import com.model.Power;
import com.model.Users;
import com.remote_interface.IUserSerivce;
import com.view.gui.UserGUI;
import com.view.vinterface.UserView;

public class UserViewImpl implements UserView{
	private UserGUI gui;
	private IUserSerivce serivce;

	public UserViewImpl(IUserSerivce s)throws Exception{
		gui = new UserGUI();
		gui.addUserListeners(a);
		serivce = s;
	}
	
	transient ActionListener sortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Users user;
			try {
				user = serivce.getUser(gui.getName());
				if(user!=null){
					Power p = user.getType();
					gui.setInfo("角色："+ p.getName());
				}else {
					gui.setInfo("用户不存在");
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	};
	
	transient ActionListener modHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				String p = gui.getType();
				Power type = p.equals("系统管理员")?Power.ADMINSTRATOR:p.equals("库存管理员")?Power.STOCKMAN:
					p.equals("进销人员")?Power.SALESMAN:p.equals("财务人员")?Power.ACCOUNT:Power.MANAGER;
				Users u1= serivce.getUser(gui.getName());
				Users u2 = new Users(u1.getUsername(),u1.getPassword(),type);
				serivce.modUser(u2);
			}catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	};
	
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				String name = gui.getName2();
				String pwd = gui.getPassword();
				if(name.length()==0||pwd.length()==0){
					MessageDialog.tip("请输入完整信息！");
					}else{
						if(serivce.isExist(name)){
							MessageDialog.tip("用户已经存在！");
						}else {
							String p = gui.getType2();
							Power type = p.equals("系统管理员")?Power.ADMINSTRATOR:p.equals("库存管理员")?Power.STOCKMAN:
								p.equals("进销人员")?Power.SALESMAN:p.equals("财务人员")?Power.ACCOUNT:Power.MANAGER;
							serivce.addUser(new Users(name,pwd,type));
							MessageDialog.tip("添加成功");
						}			
				}
			}catch (Exception  e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	};
	
	ActionListener a[]  = {sortHandler,modHandler,addHandler};
}
