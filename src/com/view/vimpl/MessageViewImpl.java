package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import com.model.Message;
import com.remote_interface.IUserService;
import com.view.gui.MessageGUI;
import com.view.vinterface.MessageView;

public class MessageViewImpl implements MessageView{
	private IUserService service;
	private MessageGUI gui;
	
	/*public MessageViewImpl(IUserSerivce s)throws Exception{
		gui = new MessageGUI();
		gui.getPanel().addMessageListeners(handlers);
		
		service = service;
	}*/
	
	public MessageViewImpl(){
		gui = new MessageGUI();
		gui.getPanel().addMessageListeners(handlers);
	}

	
	transient ActionListener showMessageHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				handleShowMessages();
		}
	};
	
	transient ActionListener showUnreadMessageHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			handleShowNotReadMessage();
		}
	};
	
	ActionListener [] handlers = {showMessageHandler,showUnreadMessageHandler};
	
	@Override
	public JInternalFrame getMessageView() {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleShowMessages() {
		// TODO Auto-generated method stub
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			messages = service.getMessage(MainViewImpl.user, 0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gui.getPanel().getTable().updateData(messages);
	}

	@Override
	public void handleShowNotReadMessage() {
		// TODO Auto-generated method stub
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			messages = service.getMessage(MainViewImpl.user, 1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gui.getPanel().getTable().updateData(messages);
	}
	

}
