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
import com.model.Power;


public class MainGUI extends JFrame{	
	private JDesktopPane desktopPane;
	private JMenu menu1,menu2,menu3,menu4,menu5,menu6,menu7;
	private JMenuBar menuBar;
	private JMenuItem spitem,spflitem,khitem,zhitem,jhitem,xsitem,zsditem,byditem,bsditem,bjditem,
	kccxitem,spcxitem,kcpditem,khcxitem,zhcxitem,jylcitem,xsmxitem,jyqkitem,rzitem,spspitem,cxitem,
	qcjjitem,xxitem,xgmmitem,tcitem;
	
	/**���췽��*/
	public MainGUI(String power,String name){
		super("���������ϵͳV1.0        ��ӭ�� "+name+"   ���Ľ�ɫ�ǣ� "+power);

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
	

	
	/** ����������Ĳ˵���*/
	private JMenuBar createMenuBar(String power){
		menuBar = new JMenuBar();
		
		//������Ϣ�����˵�
		menu1 = new JMenu("������Ϣ");
		if(power.equals(Power.ADMINSTRATOR.getName())||
				power.equals(Power.MANAGER.getName())){
			menu1.setEnabled(false);
		}
		menuBar.add(menu1);
		spitem = new JMenuItem("��Ʒ����");
		if(!power.equals(Power.STOCKMAN.getName())){
			spitem.setEnabled(false);
		}
		menu1.add(spitem);
		spflitem  = new JMenuItem("��Ʒ�������");
		if(!power.equals(Power.STOCKMAN.getName())){
			spflitem.setEnabled(false);
		}
		menu1.add(spflitem);
		khitem =  new JMenuItem("�ͻ�����");
		if(!power.equals(Power.SALESMAN.getName())){
			khitem.setEnabled(false);
		}
		menu1.add(khitem);
		zhitem = new JMenuItem("�˻�����");
		if(!power.equals(Power.ACCOUNT.getName())){
			zhitem.setEnabled(false);
		}
		menu1.add(zhitem);
		
		//�������۹����˵�
		menu2 = new JMenu("��������");
		if(!power.equals(Power.SALESMAN)){
			menu2.setEnabled(false);
		}
		menuBar.add(menu2);
		jhitem = new JMenuItem("��������");
		menu2.add(jhitem);
		xsitem = new JMenuItem("���۹���");
		menu2.add(xsitem);
		
		//��浥�����˵�
		menu3 =  new JMenu("��浥");
		if(!power.equals(Power.STOCKMAN.getName())){
			menu3.setEnabled(false);
		}
		menuBar.add(menu3);
		zsditem = new JMenuItem("���͵�");
		menu3.add(zsditem);
		byditem = new JMenuItem("���絥");
		menu3.add(byditem);
		bsditem = new JMenuItem("����");	
		menu3.add(bsditem);
		bjditem = new JMenuItem("������");
		menu3.add(bjditem);
		
		
		//��ѯ�˵�
		menu4 = new JMenu("������ѯ");
		if(power.equals(Power.ADMINSTRATOR.getName())||power.equals(Power.MANAGER.getName())){
			menu4.setEnabled(false);			
		}
		menuBar.add(menu4);
		kccxitem = new JMenuItem("����ѯ");
		if(!power.equals(Power.STOCKMAN.getName())){
			kccxitem.setEnabled(false);
		}
		menu4.add(kccxitem);
		spcxitem = new JMenuItem("��Ʒ��ѯ");
		if(!power.equals(Power.STOCKMAN.getName())){
			spcxitem.setEnabled(false);
		}
		menu4.add(spcxitem);
		kcpditem = new JMenuItem("����̵�");
		if(!power.equals(Power.STOCKMAN.getName())){
			kcpditem.setEnabled(false);
		}
		menu4.add(kcpditem);
		khcxitem = new JMenuItem("�ͻ���ѯ");
		if(!power.equals(Power.SALESMAN.getName())){
			khcxitem.setEnabled(false);
		}
		menu4.add(khcxitem);
		zhcxitem = new JMenuItem("�˻���ѯ");
		if(!power.equals(Power.ACCOUNT.getName())){
			zhcxitem.setEnabled(false);
		}
		menu4.add(zhcxitem);

		
		//�߼���ѯ�˵�
		menu5 = new JMenu("��ϸ��ѯ");
		if(!(power.equals(Power.ACCOUNT.getName())||power.equals(Power.MANAGER.getName()))){
			menu5.setEnabled(false);			
		}
		menuBar.add(menu5);
		jylcitem = new JMenuItem("��Ӫ����");
		menu5.add(jylcitem);
		xsmxitem = new JMenuItem("������ϸ");
		menu5.add(xsmxitem);
		jyqkitem = new JMenuItem("��Ӫ���");
		menu5.add(jyqkitem);
		
		//�����˵�
		menu6 = new JMenu("����");
		if(!(power.equals(Power.ACCOUNT.getName())||power.equals(Power.MANAGER.getName()))){
			menu6.setEnabled(false);
		}
		menuBar.add(menu6);
		rzitem = new JMenuItem("��־");
		menu6.add(rzitem);
		cxitem = new JMenuItem("����");
		if(!power.equals(Power.MANAGER.getName())){
			cxitem.setEnabled(false);
		}
		menu6.add(cxitem);
		spspitem = new JMenuItem("����");
		if(!power.equals(Power.MANAGER.getName())){
			spspitem.setEnabled(false);
		}
		menu6.add(spspitem);
		qcjjitem = new JMenuItem("�ڳ�����");
		if(!power.equals(Power.ACCOUNT.getName())){
			qcjjitem.setEnabled(false);
		}
		menu6.add(qcjjitem);
		
		//ϵͳ�˵�
		menu7  = new JMenu("ϵͳ");
		menuBar.add(menu7);
		xxitem = new JMenuItem("��Ϣ");
		if(power.equals(Power.ADMINSTRATOR.getName())){
			xxitem.setEnabled(false);
		}
		menu7.add(xxitem);
		xgmmitem = new JMenuItem("�޸�����");
		xgmmitem.setEnabled(false);
		menu7.add(xgmmitem);
		JMenuItem glyitem = new JMenuItem("����Ա");
		if(!power.equals(Power.ADMINSTRATOR.getName())){
			glyitem.setEnabled(false);
		}
		menu7.add(glyitem);
		tcitem = new JMenuItem("�˳�ϵͳ");
		menu7.add(tcitem);
	
		return menuBar;
		
	}
	
	
	/**Ϊmenuitemע������� */
	public void addMainListeners(ActionListener[]a){
		int len = a.length;
		if(len!=25){return;}
		
		/*spitem,spflitem,khitem,zhitem,jhitem,xsitem,zsditem,byditem,bsditem,bjditem,
		kccxitem,spcxitem,kcpditem,khcxitem,zhcxitem,jylcitem,xsmxitem,jyqkitem,rzitem,spspitem,cxitem,
		qcjjitem,xxitem,xgmmitem,tcitem;*/
		
		JMenuItem[] items = {spitem,spflitem,khitem,zhitem,jhitem,xsitem,zsditem,byditem,bsditem,bjditem,
				kccxitem,spcxitem,kcpditem,khcxitem,zhcxitem,jylcitem,xsmxitem,jyqkitem,rzitem,spspitem,cxitem,
				qcjjitem,xxitem,xgmmitem,tcitem};
		for(int i=0;i<items.length;i++){
			items[i].addActionListener(a[i]);
		}
	}
	
	

}