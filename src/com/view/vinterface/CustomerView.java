package com.view.vinterface;

import javax.swing.JInternalFrame;

public interface CustomerView {
	public JInternalFrame getCustomerView();
	public void handleAddCustomer(String name,int type,String phone,String address,String zip,String mail,double max);
	public void handleSortCustomer(String no);
	public void handleModCustomer(String no,String address,String mail,String zip,String phone,double max);

}
