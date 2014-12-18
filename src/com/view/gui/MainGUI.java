package com.view.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainGUI extends JFrame{	
	private JDesktopPane desktopPane;
	private JMenu menu1,menu2,menu3,menu4,menu5,menu6,menu7;
	private JMenuBar menuBar;
	private JMenuItem spitem,spflitem,khitem,zhitem,jhitem,xsitem,zsditem,byditem,bsditem,bjditem,
	kccxitem,spcxitem,kcpditem,khcxitem,zhcxitem,jylcitem,xsmxitem,jyqkitem,rzitem,spspitem,cxitem,
	qcjjitem,xxitem,xgmmitem,glyitem,tcitem;
	
	public MainGUI(String power,String name){
		super("进销存管理系统V1.0        欢迎： "+name+"   您的角色是： "+power);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width/6,screenSize.height/6, screenSize.width*2/3,
				screenSize.height*2/3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktopPane=new JDesktopPane();
		desktopPane.setOpaque(true);
		this.setContentPane(desktopPane);
		this.setJMenuBar(createMenuBar(power));
		desktopPane.setBackground(new Color(200,218,235));
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		this.setVisible(true);
	}

	private JMenuBar createMenuBar(String power){
		menuBar = new JMenuBar();
		
		//基本信息管理菜单
		menu1 = new JMenu("基本信息");
		if(power.equals("系统管理员")||
				power.equals("总经理")){
			menu1.setEnabled(false);
		}
		menuBar.add(menu1);
		spitem = new JMenuItem("商品管理");
		if(!power.equals("库存管理员")){
			spitem.setEnabled(false);
		}
		menu1.add(spitem);
		spflitem  = new JMenuItem("商品分类管理");
		if(!power.equals("库存管理员")){
			spflitem.setEnabled(false);
		}
		menu1.add(spflitem);
		khitem =  new JMenuItem("客户管理");
		if(!power.equals("进销人员")){
			khitem.setEnabled(false);
		}
		menu1.add(khitem);
		zhitem = new JMenuItem("账户管理");
		if(!power.equals("财务人员")){
			zhitem.setEnabled(false);
		}
		menu1.add(zhitem);
		
		//进货销售管理菜单
		menu2 = new JMenu("进货销售");
		if(!power.equals("进销人员")){
			menu2.setEnabled(false);
		}
		menuBar.add(menu2);
		jhitem = new JMenuItem("进货管理");
		menu2.add(jhitem);
		xsitem = new JMenuItem("销售管理");
		menu2.add(xsitem);
		
		//库存单管理菜单
		menu3 =  new JMenu("库存单");
		if(!power.equals("库存管理员")){
			menu3.setEnabled(false);
		}
		menuBar.add(menu3);
		zsditem = new JMenuItem("赠送单");
		menu3.add(zsditem);
		byditem = new JMenuItem("报溢单");
		menu3.add(byditem);
		bsditem = new JMenuItem("报损单");	
		menu3.add(bsditem);
		bjditem = new JMenuItem("报警单");
		menu3.add(bjditem);
		
		
		//查询菜单
		menu4 = new JMenu("基本查询");
		if(power.equals("系统管理员")||power.equals("总经理")){
			menu4.setEnabled(false);			
		}
		menuBar.add(menu4);
		kccxitem = new JMenuItem("库存查询");
		if(!power.equals("库存管理员")){
			kccxitem.setEnabled(false);
		}
		menu4.add(kccxitem);
		spcxitem = new JMenuItem("商品查询");
		if(!power.equals("库存管理员")){
			spcxitem.setEnabled(false);
		}
		menu4.add(spcxitem);
		kcpditem = new JMenuItem("库存盘点");
		if(!power.equals("库存管理员")){
			kcpditem.setEnabled(false);
		}
		menu4.add(kcpditem);
		khcxitem = new JMenuItem("客户查询");
		if(!power.equals("进销人员")){
			khcxitem.setEnabled(false);
		}
		menu4.add(khcxitem);
		zhcxitem = new JMenuItem("账户查询");
		if(!power.equals("财务人员")){
			zhcxitem.setEnabled(false);
		}
		menu4.add(zhcxitem);

		
		//高级查询菜单
		menu5 = new JMenu("明细查询");
		if(!(power.equals("财务人员")||power.equals("总经理"))){
			menu5.setEnabled(false);			
		}
		menuBar.add(menu5);
		jylcitem = new JMenuItem("经营历程");
		menu5.add(jylcitem);
		xsmxitem = new JMenuItem("销售明细");
		menu5.add(xsmxitem);
		jyqkitem = new JMenuItem("经营情况");
		menu5.add(jyqkitem);
		
		//其他菜单
		menu6 = new JMenu("其他");
		if(!(power.equals("财务人员")||power.equals("总经理"))){
			menu6.setEnabled(false);
		}
		menuBar.add(menu6);
		rzitem = new JMenuItem("日志");
		menu6.add(rzitem);
		cxitem = new JMenuItem("促销");
		if(!power.equals("总经理")){
			cxitem.setEnabled(false);
		}
		menu6.add(cxitem);
		spspitem = new JMenuItem("审批");
		if(!power.equals("总经理")){
			spspitem.setEnabled(false);
		}
		menu6.add(spspitem);
		qcjjitem = new JMenuItem("期初建账");
		if(!power.equals("财务人员")){
			qcjjitem.setEnabled(false);
		}
		menu6.add(qcjjitem);
		
		//系统菜单
		menu7  = new JMenu("系统");
		menuBar.add(menu7);
		xxitem = new JMenuItem("消息");
		if(power.equals("系统管理员")){
			xxitem.setEnabled(false);
		}
		menu7.add(xxitem);
		xgmmitem = new JMenuItem("修改密码");
		menu7.add(xgmmitem);
		glyitem = new JMenuItem("管理员");
		if(!power.equals("系统管理员")){
			glyitem.setEnabled(false);
		}
		menu7.add(glyitem);
		tcitem = new JMenuItem("退出系统");
		menu7.add(tcitem);
	
		return menuBar;
		
	}
	
	
	/**为menuitem注册监听器 */
	public void addMainListeners(ActionListener[]a){
		if(a.length!=26){return;}
		
		/*spitem,spflitem,khitem,zhitem,jhitem,xsitem,zsditem,byditem,bsditem,bjditem,
		kccxitem,spcxitem,kcpditem,khcxitem,zhcxitem,jylcitem,xsmxitem,jyqkitem,rzitem,spspitem,cxitem,
		qcjjitem,xxitem,xgmmitem,tcitem;*/
		
		JMenuItem[] items = {spitem,spflitem,khitem,zhitem,jhitem,xsitem,zsditem,byditem,bsditem,bjditem,
				kccxitem,spcxitem,kcpditem,khcxitem,zhcxitem,jylcitem,xsmxitem,jyqkitem,rzitem,spspitem,cxitem,
				qcjjitem,xxitem,xgmmitem,glyitem,tcitem};
		for(int i=0;i<items.length;i++){
			items[i].addActionListener(a[i]);
		}
	}
	
	

}
