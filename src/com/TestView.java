package com;

import com.model.User;
import com.view.gui.AccountGUI;
import com.view.gui.LoginGUI;
import com.view.gui.MainGUI;
import com.view.vimpl.MainViewImpl;
import com.view.vinterface.AccountView;

public class TestView {
	
	public static void main(String[] args) {
		
		new MainViewImpl(new User("1","2",2,0));
	}

}
