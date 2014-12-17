package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.model.CommodityCategory;
import com.remote_interface.ICommodityService;
import com.view.gui.CommodityCategoryGUI;
import com.view.vinterface.CommodityCategoryView;

public class CommodityCategoryViewImpl implements CommodityCategoryView{
	private transient CommodityCategoryGUI gui;
	private ICommodityService service;
	
	public CommodityCategoryViewImpl(ICommodityService s)throws Exception{
		service = s;
		
		gui = new CommodityCategoryGUI();
		
	}
	
	transient ActionListener showTopCateHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				gui.addCateBtn(service.showCommodityCategory(0));
				gui.showCate();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	transient ActionListener choosedHandler  = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				int id  = Integer.parseInt( e.getActionCommand());
				CommodityCategory cc = service.queryCommodityCategory(id);
				Object[] possibilities;
				if(service.isAble(id)){
					possibilities = new Object[]{"子类别","添加","删除"};
				}else{
					possibilities = new Object[]{"子类别"};
				}
				 int n = JOptionPane.showOptionDialog(null, "请选择操作类型","操作",
						 JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,possibilities,possibilities[0]);
				 switch (n) {
				case 0:
					gui.addCateBtn(service.showCommodityCategory(id));
					gui.showCate();
					break;
				case 1:
					String newCate = JOptionPane.showInputDialog("请输入新类别名称：");
					service.addCommodityCategory(newCate, cc);
					break;
				case 2:
					service.delCommodityCategory(cc);
					break;
				default:
					break;
				}
				
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	};

}
