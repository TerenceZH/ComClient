package com.view.vinterface;

import java.util.ArrayList;

import javax.swing.JInternalFrame;

public interface ImportView {

	public JInternalFrame getImportView();
	public void handleAddImport(String customer,String warehouse,String operator,ArrayList<String> list,String desc,double total);
	public void handleGetCancelableImport(int i);
	
	public void handleSortCommodity(String no);
	public void handleComfirm(String no,double price,int quantity,String desc);
}
