package com.view.vinterface;

import javax.swing.JInternalFrame;

public interface AdministratorView {
	public JInternalFrame getAdministratorView();
	public void handleModifyUser();
	public void handleAddUser(String name,String pwd,int type,int auth);
	public void handleSortUser(String name);
}
