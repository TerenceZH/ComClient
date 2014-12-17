package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.func.CommonFunc;
import com.func.MessageDialog;
import com.model.Commodity;
import com.remote_interface.ICommodityService;
import com.view.gui.CommodityGUI;
import com.view.vinterface.CommodityView;

public class CommodityViewImpl implements CommodityView {
	private transient CommodityGUI gui;
	private ICommodityService service;
	
	
	public CommodityViewImpl(ICommodityService s)throws Exception{
		service = s;
		ArrayList<String> temp = service.getCategory();
		
		gui = new CommodityGUI(temp);
		gui.addCommodityListener(a);	
		
	}
	
	
	transient  ActionListener addPanelAddHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = gui.getAddNameText();
			String style = gui.getAddStyleText();
			double inprice = gui.getAddInpriceNum();
			double outprice = gui.getAddOutpriceNum();
			String warning =  gui.getAddWarningNum();
			String cate = gui.getBox();
			
			if(name.length()==0){
				MessageDialog.tip("请输入商品名称");
			}else if(style.length()==0){
				MessageDialog.tip("请输入商品型号");
			}else if (warning.length()==0) {
				MessageDialog.tip("请输入警戒值");
			}else {
				try {
					Commodity c =new Commodity(service.getCommodityId(cate), gui.getAddNameText(), gui.getAddStyleText(), 0,
							gui.getAddInpriceNum(),gui.getAddOutpriceNum(), 0, 0, 0, Integer.parseInt(gui.getAddWarningNum()),
							CommonFunc.time(), service.gteCateid(name));
					service.addCommodity(c);
				} catch (NumberFormatException | RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	transient ActionListener addPanelResetHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.resetAdd();
		}
	};
	
	transient ActionListener delPanelSortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = gui.getDelIdText();
			try{
				ArrayList<Commodity> list = service.queryCommodity(2,id);
				if(list.size()!=0){
					Commodity c = list.get(0);
					String text = "名称："+c.getName()+"\n型号："+c.getStyle();
					gui.setDelPanelInfo(text,service.delIsAble(c));
				}else{
					MessageDialog.tip("商品不存在，请确认编号没有输入错误！");
				}
				
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	};
	
	transient ActionListener delPanelDelHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = gui.getDelIdText();
			try{				
				service.delCommodity(service.queryCommodity(2, id).get(0));
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	};
	
	transient ActionListener delPanelResetHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.resetDel();
		}
	};
	
	
	transient ActionListener modPanelSortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = gui.getModIdText();
			try{
				ArrayList<Commodity> list = service.queryCommodity(2,id);
				if(list.size()!=0){
					Commodity c = list.get(0);
					gui.setModPanelInfo(c.getInPrice()+"", c.getSalePrice()+"",c.getWarningQuantity()+"");
				}else{
					MessageDialog.tip("商品不存在，请确认编号没有输入错误！");
				}
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	};
	
	transient ActionListener modPanelModHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id  = gui.getModIdText();
			double inprice  = gui.getModInpriceNum();
			double outprice = gui.getModOutpriceNum();
			String warning  = gui.getModWarningNum();
			if(warning.length()==0){
				MessageDialog.tip("请输入警戒值");
			}else {
				try{
					Commodity c1 = service.queryCommodity(2, id).get(0);
					Commodity c2 = new Commodity(id, c1.getName(), c1.getStyle(), c1.getStockQuantity(), inprice, outprice,
							c1.getLastInPrice(), c1.getLastSalePrice(), c1.getStockAvgPrice(), Integer.parseInt(warning), c1.getTime(), c1.getCategoryId());
					service.modCommodity(c2);
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
	};
	
	transient ActionListener modPanelResetHandler  = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.resetMod();
		}
	};
	
	ActionListener[] a = {addPanelAddHandler,addPanelResetHandler, delPanelSortHandler,delPanelResetHandler ,
			modPanelSortHandler, modPanelModHandler,modPanelResetHandler};

}
