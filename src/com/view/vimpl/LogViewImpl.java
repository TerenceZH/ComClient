package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import com.func.MessageDialog;
import com.remote_interface.ILogService;
import com.view.gui.LogGUI;
import com.view.gui.LogGUI.LogPanel;
import com.view.vinterface.LogView;

public class LogViewImpl implements LogView{
	private transient LogGUI gui;
	private ILogService service;
	
	public LogViewImpl(ILogService s)throws Exception{
		service = s;	
		gui = new LogGUI();
		gui.getLogPanel().addLogListeners(a);
	}
	
	transient ActionListener queryByTimeHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stime = gui.getLogPanel().getStartTime();
			String etime = gui.getLogPanel().getEndTime();
			if(stime.length()==0||etime.length()==0){
				MessageDialog.tip("«Î ‰»Î»’∆⁄£°");
			}else {
				try {
					gui.getLogPanel().getTable().updateData(service.queryByTime(stime,etime));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	};
	
	transient ActionListener queryAllHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				gui.getLogPanel().getTable().updateData(service.queryAllLogs());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	ActionListener [] a = {queryByTimeHandler,queryAllHandler};

}
