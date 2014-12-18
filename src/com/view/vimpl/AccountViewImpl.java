package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.func.CommonFunc;
import com.func.MessageDialog;
import com.model.Account;
import com.remote_interface.IAccountService;
import com.view.gui.AccountGUI;
import com.view.vinterface.AccountView;

public class AccountViewImpl implements AccountView{
	private transient AccountGUI gui;
	private IAccountService service;
	
	/*public AccountViewImpl(IAccountService s)throws Exception{
		gui = new AccountGUI();
		gui.addAccountListeners(handlers);
		
		service = s;
	}*/
	
	public AccountViewImpl(){
		gui = new AccountGUI();
		gui.addAccountListeners(handlers);
	}
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = gui.getName();
			String money = gui.getMoney();
			double m = money.length()==0?0:Double.parseDouble(money);
			if(name.length()==0){
				MessageDialog.tip("名称不能为空！");
			}else {
				handleAddAccount(name, m, CommonFunc.time());
			}
		}
	};
	
	transient ActionListener sortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo();
			if(no.length()==0){
				MessageDialog.tip("请输入编号");
			}else {
				handleSortAccount(no);
			}
		}
	};
	
	transient ActionListener modHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getNo();
			String name = gui.getName2();
			
			if(no.length()==0){
				MessageDialog.tip("请输入编号");
			}else if (name.length()==0) {
				MessageDialog.tip("请输入新名称");
			}else {
				handleModAccount(no, name);
			}
		}
	};
	
	ActionListener[] handlers = {addHandler,sortHandler,modHandler};

	@Override
	public JInternalFrame getAccountView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddAccount(String name, double money, String time) {
		// TODO Auto-generated method stub
		try {
			service.addAccount(name, money, time,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleSortAccount(String no) {
		// TODO Auto-generated method stub
	    try {
			Account account = service.queryAccount(no);
			if(account==null){
				MessageDialog.tip("账户不存在！");
			}else {
				gui.setName(account.getName());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleModAccount(String no,String name) {
		// TODO Auto-generated method stub
		try {
			service.modAccount(no, name, MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
