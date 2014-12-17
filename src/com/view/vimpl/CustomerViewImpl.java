package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import com.func.MessageDialog;
import com.model.Customer;
import com.remote_interface.ICustomerService;
import com.view.gui.CustomerGUI;
import com.view.vinterface.CustomerView;

public class CustomerViewImpl implements CustomerView{
	private transient CustomerGUI gui;
	private ICustomerService service;
	
	public CustomerViewImpl(ICustomerService s)throws Exception{
		gui = new CustomerGUI();
		gui.addCustomerListeners(a);
		service = s;
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
			double m = max.length()==0?100:Double.parseDouble(max);
			if(name.length()==0){
				MessageDialog.tip("请填写客户名！");
			}else {
				Customer c = new Customer(name,t,name,0,1,phone,address,zip,mail,m,0,0,MainViewImpl.user.getUsername());
				try {
					service.addCustomer(c);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	transient ActionListener sortHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = gui.getId2();
			Customer c = null; 
			try {
				if(service.queryCustomerByKeyword(id).size()==0){
					MessageDialog.tip("客户不存在");
				}else {
					c = service.queryCustomerByKeyword(id).get(0);
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			gui.setText(c.getPhone(), c.getAddress(),c.getZip(),c.getMail(),c.getMax_to_get()+"");
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
			double m = max.length()==0?100:Double.parseDouble(max);
			String zip = gui.getZip2();
			String phone = gui.getPhone2();
			try{
			Customer c1 = service.queryCustomerByKeyword(id).get(0);
			Customer c2 = new Customer(id,c1.getType(),id,c1.getPoint(),c1.getLevel(),phone,address,zip,mail,m,
					c1.getTo_pay(),c1.getTo_pay(),c1.getDefault_businessman());
			service.modCustomer(c2);
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}
	};
	
	ActionListener a[] = {addHandler,sortHandler,modHandler};
	

}
