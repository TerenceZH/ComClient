package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;

import com.func.MessageDialog;
import com.model.Customer;
import com.remote_interface.ICustomerService;
import com.view.gui.CustomerGUI;
import com.view.vinterface.CustomerView;

public class CustomerViewImpl implements CustomerView{
	private transient CustomerGUI gui;
	private ICustomerService service;
	
	/*public CustomerViewImpl(ICustomerService s)throws Exception{
		gui = new CustomerGUI();
		gui.addCustomerListeners(a);
		service = s;
	}*/
	
	public CustomerViewImpl(){
		gui = new CustomerGUI();
		gui.addCustomerListeners(a);
	}
	
	
	transient ActionListener addHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = gui.getName();
			String type = gui.getType();
			String address  = gui.getAddress();
			String mail = gui.getMail();
			String max = gui.getMax();
			String zip = gui.getZip();
			String phone = gui.getPhone();
			int t = type.equals("进货商")?0:1;
			double m = max.length()==0?0:Double.parseDouble(max);
			if(name.length()==0){
				MessageDialog.tip("请填写客户名！");
			}else {
				handleAddCustomer(name, t, phone, address, zip, mail,m);
			}
		}
	};
	
	transient ActionListener sortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = gui.getId2();
			handleSortCustomer(id);
		}
	};
	
	transient ActionListener modHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = gui.getId2();
			String address  = gui.getAddress2();
			String mail = gui.getMail2();
			String max = gui.getMax2();
			double m = max.length()==0?0:Double.parseDouble(max);
			String zip = gui.getZip2();
			String phone = gui.getPhone2();
			
			handleModCustomer(id, address, mail, zip, phone, m);
		}
	};
	
	ActionListener a[] = {addHandler,sortHandler,modHandler};

	@Override
	public JInternalFrame getCustomerView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddCustomer(String name, int type, String phone,
			String address, String zip, String mail,double max) {
		// TODO Auto-generated method stub
		try {
			service.addCustomer(name, type, address, phone, zip, mail, max,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleSortCustomer(String no) {
		// TODO Auto-generated method stub
		try {
			Customer customer = service.queryCustomer(no);
			if(customer==null){
				MessageDialog.tip("客户不存在！");
			}else {
				gui.setText(customer.getPhone(), customer.getAddress(),customer.getZip(),
						customer.getMail(),customer.getMax()+"");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void handleModCustomer(String no, String address, String mail,
			String zip, String phone, double max) {
		// TODO Auto-generated method stub
		try {
			service.modCustomer(no, address, phone, zip, mail, max, MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
