package com.view.vinterface;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public interface ChangePasswordView {
	public void handlerCHangePwd(String old,String new1,String new2);
	public JInternalFrame getChangePasswordView();
}
