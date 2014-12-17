package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.model.Users;
import com.view.gui.MainGUI;
import com.view.vinterface.MainView;

public class MainViewImpl implements MainView{
	private MainGUI gui;
	public static Users user;
	
	public MainViewImpl(Users u)throws Exception{
		gui = new MainGUI(u.getType().getName(), u.getUsername());
		gui.addMainListeners(mainListeners);
	}
	
	
	
	/*spitem,spflitem,khitem,zhitem,jhitem,xsitem,zsditem,byditem,bsditem,bjditem,
	kccxitem,spcxitem,kcpditem,khcxitem,zhcxitem,jylcitem,xsmxitem,jyqkitem,rzitem,spspitem,cxitem,
	qcjjitem,xxitem,xgmmitem,tcitem;*/
	
	transient ActionListener spitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	transient ActionListener spflitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	transient ActionListener khitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	transient ActionListener zhitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener jhitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener xsitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener byditemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener zsditemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener bjditemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener bsditemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener kccxitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener spcxitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener kcpditemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener khcxitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener zhcxitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener jylcitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener jyqkitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener xsmxitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener rzitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
transient ActionListener spspitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	
transient ActionListener cxitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener qcjjitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener xxitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener xgmmitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
transient ActionListener tcitemListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	/*spitem,spflitem,khitem,zhitem,jhitem,xsitem,zsditem,byditem,bsditem,bjditem,
	kccxitem,spcxitem,kcpditem,khcxitem,zhcxitem,jylcitem,xsmxitem,jyqkitem,rzitem,spspitem,cxitem,
	qcjjitem,xxitem,xgmmitem,tcitem;*/
	
	transient ActionListener[] mainListeners = {spitemListener,spflitemListener,khitemListener,
			zhitemListener,jhitemListener,xsitemListener,zsditemListener,byditemListener,bsditemListener,
			bjditemListener,kccxitemListener,spcxitemListener,kcpditemListener,khcxitemListener,zhcxitemListener,jylcitemListener,
			xsmxitemListener,jyqkitemListener,rzitemListener,spspitemListener,cxitemListener,
			qcjjitemListener,xxitemListener,xgmmitemListener,tcitemListener};
 
}
