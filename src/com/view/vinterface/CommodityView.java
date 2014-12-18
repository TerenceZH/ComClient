package com.view.vinterface;

import javax.swing.JInternalFrame;

public interface CommodityView {
	public JInternalFrame getCommodityView();
	public void handleAddCommodity(String s1,String s2,String s3,double d1,double d2,int t);
	public void handleDelCommodity(String no);
	public void handleSortCommodity(String no);
	public void handleModCommodity(String no,double p1,double p2,int w);
	public void handleSortCommodity2(String no);
}
