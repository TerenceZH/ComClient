package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import com.func.CommonFunc;
import com.func.MessageDialog;
import com.model.Commodity;
import com.model.ExportBill;
import com.model.ImportBill;
import com.model.PortBillItem;
import com.remote_interface.IExportService;
import com.view.gui.IExportViewGUI;
import com.view.vinterface.ExportView;

public class ExportViewImpl implements ExportView{
	private IExportService service;
	private IExportViewGUI gui;
	
	private int i = 0;
	
	/*public ExportViewImpl(IExportService s)throws Exception{
		gui = new IExportViewGUI();
		gui.addExportListener(a1);
		gui.getFrame().addItemActionListeners(a2);
		gui.setOperator(MainViewImpl.user.getId());
		
		service  = s;
	}*/
	
	public ExportViewImpl(){
		gui = new IExportViewGUI();
		gui.addExportListener(a1);
		gui.getFrame().addItemActionListeners(a2);
		gui.setOperator(MainViewImpl.user.getId());
	}
	
	
	transient ActionListener addExportHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String customer = gui.getCustomer();
			String warehouse = gui.getWarehouse();
			String operator = gui.getOperator();
			String total = gui.getTotal();
			String discount =gui.getDiscount();
			String djq = gui.getDjq();
			String total2 = gui.getTotal2();
			String desc = gui.getDesc();
			ArrayList<String> list = gui.getList();
			
			if(customer.length()==0||warehouse.length()==0||operator.length()==0||total.length()==0||total2.length()==0){
				MessageDialog.tip("请填写完整！");
			}else {
				handleAddExport(customer, warehouse, operator, list,desc, Double.parseDouble(total),Double.parseDouble(discount),
						Double.parseDouble(djq),Double.parseDouble(total2));
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
	
	
	transient ActionListener getDjqHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String no = gui.getCustomer();
			if(no.length()==0){
				MessageDialog.tip("请输入客户编号");
			}else {
				handleGetDjq(no);
			}
		}
	};
	
	transient ActionListener getCancelableHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			i = 1;
			handleGetCancelableExport(i);
		}
	};
	
	transient ActionListener getNextHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			i++;
			handleGetCancelableExport(i);
		}
	};
	
	
	transient ActionListener addCancelExportHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String desc = gui.getDesc2();
			if(i==0){
				MessageDialog.tip("请选择要退货的单子");
			}else {
				try {
					ExportBill iBill = service.getCancelableExport(i);
					ArrayList<PortBillItem> list = new ArrayList<PortBillItem>();
					ArrayList<String> list2 = new ArrayList<String>();
 					for(PortBillItem i:list){
						list2.add(i.getCommodityNo()+","+i.getPrice()+","+i.getQuantity()+","+i.getTotal()+","+i.getDesc());
					}
					service.addExport(1, iBill.getCustomerNo(), iBill.getWarehouseNo(), MainViewImpl.user.getId(),
							iBill.getPreTotal(), iBill.getDiscount(), iBill.getDjq(), iBill.getPostTotal(), desc, list2, CommonFunc.time());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	ActionListener a1[] = {addItemHandler,addExportHandler,getDjqHandler,getCancelableHandler,getNextHandler,addCancelExportHandler};
	
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
			
			String cno = gui.getCustomer();
			double discount = 10;
			try {
				discount = service.getDiscount(cno);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(no.length()==0||price.length()==0||quantity.length()==0){
				MessageDialog.tip("请填写完整！");
			}else {
				handleComfirm(no, Double.parseDouble(price), Integer.parseInt(quantity), desc,discount);
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
	public JInternalFrame getExportView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddExport(String customer, String warehouse,
			String operator, ArrayList<String> list, String desc, double total,
			double discount, double djq, double total2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleGetCancelableExport(int i) {
		// TODO Auto-generated method stub
		try {
			ExportBill iBill = service.getCancelableExport(i);
			if(iBill==null){
				MessageDialog.tip("没有可以退货的单子");
				gui.getCancelButton().setEnabled(false);
			}else {
				gui.setId(iBill.getNo());
				gui.setCustomer(iBill.getCustomerNo());
				gui.setTime(iBill.getTime());
				gui.setTotal3(iBill.getPostTotal()+"");
				gui.setDesc(iBill.getDesc());
				gui.getCancelButton().setEnabled(true);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void handleGetDjq(String no) {
		// TODO Auto-generated method stub
		try {
			MessageDialog.tip("有"+service.getDjq(no)+"元代金券");
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
			gui.getFrame().setPrice(c.getOutPrice()+"");
		}
	}

	@Override
	public void handleComfirm(String no, double price, int quantity, String desc,double discount) {
		// TODO Auto-generated method stub
		String s1 = no+","+price+","+quantity+","+quantity*price+","+desc;
		String total1 = gui.getTotal();
		String total2 = Double.parseDouble(total1)+quantity*price+"";
		gui.setTotal(total2);
		
		gui.setDiscount(new DecimalFormat("######0.00").format(Double.parseDouble(total2)*(1-discount/10)));
		gui.setTotal2((Double.parseDouble(gui.getTotal())-Double.parseDouble(gui.getDiscount()))+"");
		gui.addToCommodityList(s1);
		gui.addToList("编号："+no+"  单价："+price+"  数量："+quantity+"  总价："+price*quantity+" ");
		gui.getFrame().setNull();
		gui.getFrame().setVisible(false);
	}
	
	
	

}
