package com.view.vinterface;

import java.util.ArrayList;

import javax.swing.JInternalFrame;

public interface ExportView {

	public JInternalFrame getExportView();

	public void handleAddExport(String customer,String warehouse,String operator,ArrayList<String> list,String desc,double total,double discount,double djq,double total2);
	public void handleGetCancelableExport(int i);
	public void handleGetDjq(String no);
	public void handleSortCommodity(String no);
	public void handleComfirm(String no,double price,int quantity,String desc,double discount);
}
