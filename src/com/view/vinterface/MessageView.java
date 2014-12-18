package com.view.vinterface;

import javax.swing.JInternalFrame;

public interface MessageView {
    public JInternalFrame getMessageView();
    public void handleShowMessages();
    public void handleShowNotReadMessage();
}
