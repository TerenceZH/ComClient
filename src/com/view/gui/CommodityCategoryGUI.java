package com.view.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import com.model.CommodityCategory;

public class CommodityCategoryGUI extends JInternalFrame{
	private JButton showTopCatebutton;
	private ArrayList<JButton> catesButtons;
	private JPanel cateJPanel;
	private JPanel[]  catePanels;
	
	public CommodityCategoryGUI(){
		super("商品分类管理", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		categoryLayout();
		
		this.setVisible(true);
	}
	
	private void categoryLayout(){
		showTopCatebutton = new JButton("查看最顶层分类");
		cateJPanel = new JPanel();
		showCate();
	}
	
	public void addCategoryListeners(ActionListener []a){
		ArrayList<JButton> list = new ArrayList<JButton>();
		list.add(showTopCatebutton);
		for(JButton j:catesButtons){
			list.add(j);
		}
		if(a.length!=list.size()){
			return;
		}
		for(int i =0;i<list.size();i++){
			list.get(i).addActionListener(a[i]);
		}
	}

	public void addCateBtn(ArrayList<CommodityCategory> c){
		catesButtons = new ArrayList<JButton>();
		for(CommodityCategory cc:c){
			JButton button = new JButton(cc.getName());
			button.setActionCommand(cc.getNode_id()+"");
			catesButtons.add(button);
		}
	}
	
	public void showCate(){
		if(catesButtons!=null){
			catePanels = new JPanel[catesButtons.size()/2];
			for(int i=0;i<catePanels.length;i++){
				catePanels[i] = new JPanel();
				catePanels[i].add(catesButtons.get(2*i));
				if((2*i+1)<=catesButtons.size()-1)
					catePanels[i].add(catesButtons.get(2*i+1));
				
				cateJPanel.add(catePanels[i]);
			}
		}
	}
}
