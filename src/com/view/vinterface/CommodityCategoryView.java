package com.view.vinterface;

import javax.swing.JInternalFrame;

public interface CommodityCategoryView {
	
	public JInternalFrame getCommodityCategoryView();
	public void handleAddCategory(String name,String no);
	public void handleDelCategory(String no);
	public void handleModCategory(String name,String no);
	public void handleShowSonCategories(String no);

}
