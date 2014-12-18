package com.view.vimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.remote_interface.ICommodityService;
import com.view.gui.CommodityCategoryGUI;
import com.view.vinterface.CommodityCategoryView;

public class CommodityCategoryViewImpl implements CommodityCategoryView{
	private transient CommodityCategoryGUI gui;
	private ICommodityService service;
	
	/*public CommodityCategoryViewImpl(ICommodityService s)throws Exception{
		service = s;
		
		gui = new CommodityCategoryGUI();
		gui.addCategoryListeners(handlers);
	}*/
	
	public CommodityCategoryViewImpl(){
		gui = new CommodityCategoryGUI();
		gui.addCategoryListeners(handlers);
	}
	
	transient ActionListener showTopCateHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				gui.addCateBtn(service.queryCategoryByParentNo("000"),choosedHandler);
				gui.showCate();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	transient ActionListener addTopCateHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = JOptionPane.showInputDialog("请输入新类别名称：");
			handleAddCategory(name,"000");
		}
	};
	
	ActionListener[] handlers = {showTopCateHandler,addTopCateHandler};
	
	transient ActionListener choosedHandler  = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				String no = e.getActionCommand();
				Object[] possibilities = new Object[]{"子类别","添加","修改","删除"};
				int n = JOptionPane.showOptionDialog(null, "请选择操作类型","操作",
						 JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,possibilities,possibilities[0]);
				switch (n) {
				case 0:
					handleShowSonCategories(no);
					break;
				case 1:
					String name = JOptionPane.showInputDialog("请输入新类别名称：");
					if(name.length()!=0)
						handleAddCategory(name, no);
					break;
				case 2:
					String name2 = JOptionPane.showInputDialog("请输入新名称:");
					if(name2.length()!=0)
						handleModCategory(name2, no);
					break;
				case 3:
					handleDelCategory(no);
					break;
				default:
					break;
				}
				
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	};

	@Override
	public JInternalFrame getCommodityCategoryView()  {
		// TODO Auto-generated method stub
		return gui;
	}

	@Override
	public void handleAddCategory(String name,String no)  {
		// TODO Auto-generated method stub	
		try {
			service.addCommodityCategory(name, no,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleDelCategory(String no) {
		// TODO Auto-generated method stub
		try {
			service.delCommdoityCategory(no,MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleModCategory(String name,String no) {
		// TODO Auto-generated method stub
		try {
			service.modCommodityCategory(name, no, MainViewImpl.user.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handleShowSonCategories(String no) {
		// TODO Auto-generated method stub
		try {
			gui.addCateBtn(service.queryCategoryByParentNo(no),choosedHandler);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gui.showCate();
	}

}
