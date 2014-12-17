package com.view.vinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.model.User;

public interface LoginView extends Remote{

	public boolean login(String uname, String password);
	
	public void getMainView(User user);
}
