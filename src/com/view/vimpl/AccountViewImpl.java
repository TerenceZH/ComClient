package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import com.func.MessageDialog;
import com.model.Account;
import com.remote_interface.IAccountService;
import com.view.gui.AccountGUI;
import com.view.vinterface.AccountView;

public class AccountViewImpl implements AccountView{
	private transient AccountGUI gui;
	private IAccountService service;
	
	public AccountViewImpl(IAccountService s)throws Exception{
		gui = new AccountGUI();
		gui.addAccountListeners(addHandler);
		
		service = s;
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
				Account a = new Account(name,m);
				try {
					service.addAccount(a);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};

}
