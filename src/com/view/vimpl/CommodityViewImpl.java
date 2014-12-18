package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import com.func.CommonFunc;
import com.func.MessageDialog;
import com.model.Commodity;
import com.model.CommodityCategory;
import com.remote_interface.ICommodityService;
import com.view.gui.CommodityGUI;
import com.view.vinterface.CommodityView;

public class CommodityViewImpl implements CommodityView {
	private transient CommodityGUI gui;
	private ICommodityService service;
	
	
	public CommodityViewImpl(ICommodityService s)throws Exception{
		service = s;
		ArrayList<CommodityCategory> list  = service.getAllCommodityCategories();
		ArrayList<String> cateList = new ArrayList<String>();
		cateList.add("请选择");
		for(CommodityCategory cc:list){
			cateList.add(cc.getName());
		}
		
		gui.setCatelist(cateList);
		
		gui = new CommodityGUI();
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
			}else if(cate.equals("请选择")){
				MessageDialog.tip("请选择类别");
			}else if(style.length()==0){
				MessageDialog.tip("请输入商品型号");
			}else if (warning.length()==0) {
				MessageDialog.tip("请输入警戒值");
			}else {
				handleAddCommodity(name, style, cate, inprice, outprice, Integer.parseInt(warning));
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
			handleSortCommodity(id);
		}
	};
	
	transient ActionListener delPanelDelHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = gui.getDelIdText();
			handleDelCommodity(id);	
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
				handleModCommodity(id, inprice, outprice, Integer.parseInt(warning));
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


	@Override
	public JInternalFrame getCommodityView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddCommodity(String s1, String s2, String s3, double d1,
			double d2, int t) {
		// TODO Auto-generated method stub
		try {
			service.addCommodity(s1,s2,s3,d1,d2,t,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleDelCommodity(String no) {
		// TODO Auto-generated method stub
		try{
			service.delCommodity(no,MainViewImpl.user.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void handleSortCommodity(String no) {
		// TODO Auto-generated method stub
		try{
			Commodity commodity = service.queryCommodity(no);
			if(commodity==null){
				gui.setDelPanelInfo("不存在",false);
			}else {
				gui.setDelPanelInfo(commodity.getName()+" "+commodity.getStyle(), true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	@Override
	public void handleModCommodity(String no,double p1,double p2,int w) {
		// TODO Auto-generated method stub
		try {
			service.modCommodity(no, p1, p2, w,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleSortCommodity2(String no) {
		// TODO Auto-generated method stub
		try{
			Commodity commodity = service.queryCommodity(no);
			if(commodity==null){
				;
			}else {
				gui.setModPanelInfo(commodity.getInPrice()+"",commodity.getOutPrice()+"",commodity.getWarningQuantity()+"");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
	
