package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import com.func.CommonFunc;
import com.func.MessageDialog;
import com.model.Commodity;
import com.model.ImportBill;
import com.model.PortBillItem;
import com.remote_interface.IImportService;
import com.view.gui.ImportViewGUI;
import com.view.vinterface.ImportView;

public class ImportViewImpl implements ImportView{
	private ImportViewGUI gui;
	private IImportService service;
	
	private int i = 0;
	/*
	public ImportViewImpl(IImportService s)throws Exception{
		gui = new ImportViewGUI();
		gui.addImportListener(a1);
		gui.getFrame().addItemActionListeners(a2);
		gui.setOperator(MainViewImpl.user.getId());
		
		service = s;
	}*/
	
	public ImportViewImpl(){
		gui = new ImportViewGUI();
		gui.addImportListener(a1);
		gui.getFrame().addItemActionListeners(a2);
		gui.setOperator(MainViewImpl.user.getId());
	}
	
	transient ActionListener addImportHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customer = gui.getCustomer();
			String warehouse = gui.getWarehouse();
			String operator = gui.getOperator();
			String total = gui.getTotal();
			String desc = gui.getDesc();
			ArrayList<String> list = gui.getList();
			
			if(customer.length()==0||warehouse.length()==0||operator.length()==0||total.length()==0){
				MessageDialog.tip("请填写完整！");
			}else {
				handleAddImport(customer, warehouse, operator, list,desc, Double.parseDouble(total));
			}
			
		}
	};
	
	transient ActionListener addItemHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getFrame().setVisible(true);
		}
	};

	transient ActionListener getCancelableHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			i = 1;
			handleGetCancelableImport(i);
		}
	};
	
	transient ActionListener getNextHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			i++;
			handleGetCancelableImport(i);
		}
	};
	
	transient ActionListener addCancelImportHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String desc = gui.getDesc2();
			if(i==0){
				MessageDialog.tip("请选择要退货的单子");
			}else {
				try {
					ImportBill iBill = service.getCancelableImport(i);
					ArrayList<PortBillItem> list = new ArrayList<PortBillItem>();
					ArrayList<String> list2 = new ArrayList<String>();
 					for(PortBillItem i:list){
						list2.add(i.getCommodityNo()+","+i.getPrice()+","+i.getQuantity()+","+i.getTotal()+","+i.getDesc());
					}
					service.addImport(1, iBill.getCustomerNo(), iBill.getWarehouseNo(), MainViewImpl.user.getId(),list2 , desc, CommonFunc.time(), iBill.getTotal());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	
	ActionListener a1[] = {addItemHandler,addImportHandler,getCancelableHandler,getNextHandler,addCancelImportHandler};
	
	
	transient ActionListener sortCommodityHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getFrame().getCommodity();
			
			if(no.length()==0){
				MessageDialog.tip("请输入商品编号！");
			}
			handleSortCommodity(no);
		}
	};
	
	
	transient ActionListener confirmHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getFrame().getCommodity();
			String price = gui.getFrame().getPrice();
			String quantity = gui.getFrame().getQuantity();
			String desc = gui.getFrame().getDesc();
			
			if(no.length()==0||price.length()==0||quantity.length()==0){
				MessageDialog.tip("请填写完整！");
			}else {
				handleComfirm(no, Double.parseDouble(price), Integer.parseInt(quantity), desc);
			}
		}
	};
	
	transient ActionListener cancelHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getFrame().setNull();
			gui.getFrame().setVisible(false);
		}
	};
	
	ActionListener [] a2 = {sortCommodityHandler,confirmHandler,cancelHandler};
	
	
	
	
	@Override
	public JInternalFrame getImportView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddImport(String customer, String warehouse,
			String operator, ArrayList<String>list,String desc, double total) {
		// TODO Auto-generated method stub
		try {
			service.addImport(0,customer, warehouse, operator, list,desc, CommonFunc.time(), total);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleGetCancelableImport(int i) {
		// TODO Auto-generated method stub
		try {
			ImportBill iBill = service.getCancelableImport(i);
			if(iBill==null){
				MessageDialog.tip("没有可以退货的单子");
				gui.getCancelButton().setEnabled(false);
			}else {
				gui.setId(iBill.getNo());
				gui.setCustomer(iBill.getCustomerNo());
				gui.setTime(iBill.getTime());
				gui.setTotal2(iBill.getTotal()+"");
				gui.setDesc(iBill.getDesc());
				gui.getCancelButton().setEnabled(true);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleSortCommodity(String no) {
		// TODO Auto-generated method stub
		Commodity c = null;
		try {
			c = service.getCommodity(no);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c==null){
			MessageDialog.tip("商品不存在");
		}else {
			gui.getFrame().setPrice(c.getInPrice()+"");
		}
	}

	@Override
	public void handleComfirm(String no, double price, int quantity, String desc) {
		// TODO Auto-generated method stub
		String s1 = no+","+price+","+quantity+","+quantity*price+","+desc;
		String total1 = gui.getTotal();
		String total2 = Double.parseDouble(total1)+quantity*price+"";
		gui.setTotal(total2);
		gui.addToCommodityList(s1);
		gui.addToList("编号："+no+"  单价："+price+"  数量："+quantity+"  总价："+price*quantity+" ");
		gui.getFrame().setNull();
		gui.getFrame().setVisible(false);
	}

}
