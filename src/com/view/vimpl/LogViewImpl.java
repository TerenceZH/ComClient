package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import com.func.CommonFunc;
import com.func.MessageDialog;
import com.model.Log;
import com.remote_interface.ILogService;
import com.view.gui.LogGUI;
import com.view.gui.LogGUI.LogPanel;
import com.view.vinterface.LogView;

public class LogViewImpl implements LogView{
	private transient LogGUI gui;
	private ILogService service;
	
	/*public LogViewImpl(ILogService s)throws Exception{
		service = s;	
		gui = new LogGUI();
		gui.getLogPanel().addLogListener(sortLogHandler);
	}*/
	
	public LogViewImpl(){
		gui = new LogGUI();
	}
	
	transient ActionListener sortLogHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String stime = gui.getLogPanel().getStartTime();
			String etime = gui.getLogPanel().getEndTime();
			String type = gui.getLogPanel().getType();
			
			String format = "yyyy-MM-dd";
			
			if(stime.length()!=0 && !CommonFunc.isValidTimeFormat(stime, format)){
				MessageDialog.tip("时间格式错误（yyyy-MM-dd）");
			}else if(etime.length()!=0 && !CommonFunc.isValidTimeFormat(etime, format)){
				MessageDialog.tip("时间格式错误（yyyy-MM-dd）");
			}else if(stime.length()==0 && etime.length()!=0){
				MessageDialog.tip("请填写开始时间");
			}else{
				if(stime.length()!=0 && etime.length()==0){
					if(CommonFunc.time2().compareTo(stime)<0){
						MessageDialog.tip("开始时间不能大于今天");
					}else {
						etime = CommonFunc.time2();
					}
				}
				handleSortLog(stime, etime, type);
			}
			
		}
	};

	@Override
	public JInternalFrame getLogView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleSortLog(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
		ArrayList<Log> list = new ArrayList<Log>();
		try{
			if(s1.length()==0 && s2.length()==0){
				if(s3.equals("")){
					list = service.queryLog();
				}else {
					list = service.queryLog(s3);
				}
			}else {
				if(s3.equals("")){
					list = service.queryLog(s1, s2);
				}else {
					list = service.queryLog(s1, s2, s3);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		gui.getLogPanel().getTable().updateData(list);
	}
	


}
