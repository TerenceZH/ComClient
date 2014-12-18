package com.view.vinterface;

import javax.swing.JInternalFrame;

public interface AccountView {
	public JInternalFrame getAccountView();
	public void handleAddAccount(String name,double money,String time);
	public void handleSortAccount(String no);
	public void handleModAccount(String no,String name);

}
