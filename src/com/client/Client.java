package com.client;

import java.net.URL;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import com.remote_interface.IUserSerivce;
import com.view.vimpl.LoginViewImpl;
import com.view.vinterface.LoginView;

public class Client {
	public static void main(String[] args) {
		String host = "rmi://192.168.47.12/8787";
		
		if(args.length>0){
			host=args[0];
		}
		
		URL policyURL = Client.class.getResource("java.policy");
	    if(policyURL != null){
	         System.setProperty("java.security.policy", policyURL.toString());  
	         System.setSecurityManager(new RMISecurityManager());  
	    }else {
			System.err.println("√ª”–’“µΩjava.policy");
		}
	    
	    try{
	    	IUserSerivce userSerivce = (IUserSerivce)Naming.lookup(host+"/UserService");
	    	
	    	LoginView view = new LoginViewImpl(userSerivce);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
  
	}
	

}
