package com.view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.model.CommodityCategory;

public class CommodityCategoryGUI extends JInternalFrame{
	private JButton showTopCatebutton,addTopCatebutton;
	private ArrayList<JButton> catesButtons;
	
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
		addTopCatebutton = new JButton("添加最顶层分类");
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(showTopCatebutton);
		p.add(addTopCatebutton);
		
		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(p);
		jp.add(showCate());
		
		this.getContentPane().add(jp);
	}
	
	public void addCategoryListeners(ActionListener []a){
		if(a.length!=2){
			return;
		}
		showTopCatebutton.addActionListener(a[0]);
		addTopCatebutton.addActionListener(a[1]);
	}

	public void addCateBtn(ArrayList<CommodityCategory> c,ActionListener a){
		catesButtons = new ArrayList<JButton>();
		for(CommodityCategory cc:c){
			JButton button = new JButton(cc.getName());
			button.setActionCommand(cc.getNo());
			button.addActionListener(a);
			catesButtons.add(button);
		}
	}
	
	public JPanel showCate(){
		JPanel cateJPanel = new JPanel();
		cateJPanel.setLayout(new BoxLayout(cateJPanel, BoxLayout.Y_AXIS));
		if(catesButtons!=null){
			for(JButton j:catesButtons){
				cateJPanel.add(j);
			}
		}else{
			JLabel jl = new JLabel("无类别");
			cateJPanel.add(jl);
		}
		return cateJPanel;
	}
}
