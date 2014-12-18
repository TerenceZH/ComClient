package com.view.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CommodityGUI extends JInternalFrame{
	private JTextField cname,cstyle,cinprice,coutprice,cwarning;
	private JComboBox<String> box;
	private JButton addbtn,resetbtn;
	private JTextField cid2;
	private JButton sortbtn2,delbtn2,resetbtn2;
	private JTextArea info2;
	private JTextField cid3,cinprice3,coutprice3,cwarning3;
	private JButton sortbtn3,modbtn3,resetbtn3;
	private String boxString = "请选择";
	private ArrayList<String> cateList;
	
	private JPanel addPanel,delPanel,modPanel;
	
	private JTabbedPane tabbedPane;

	public CommodityGUI(){
		super("商品信息管理", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
	}
	
	/**监听*/
	public void addCommodityListener(ActionListener []a){
		JButton[] buttons = {addbtn,resetbtn,sortbtn2,delbtn2,resetbtn2,sortbtn3,modbtn3,resetbtn3};
		if(a.length!=buttons.length){
			return;
		}
		for(int i =0;i<buttons.length;i++){
			buttons[i].addActionListener(a[i]);
		}
		
	}
	
	private JTabbedPane createTabbedPane(){
		tabbedPane = new JTabbedPane();
		
		addPane(tabbedPane);
		delPane(tabbedPane);
		modPane(tabbedPane);
		
		return tabbedPane;
	}
	
	
	private void addPane(JTabbedPane p){
		addPanel = new JPanel();
		addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.Y_AXIS));
		cname = new JTextField(20);
		cstyle = new JTextField(20);
		cinprice = new JTextField(7);
		coutprice = new JTextField(7);
		cwarning = new JTextField(10);
		box = new JComboBox<String>();
		box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					boxString = (String)box.getSelectedItem();
				}
			}
		});
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("名称：");
		jp1.add(jl1);
		jp1.add(cname);
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("型号：");
		jp2.add(jl2);
		jp2.add(cstyle);
		JPanel jp = new JPanel();
		JLabel jl = new JLabel("类别");
		for(String s:cateList){
			box.addItem(s);
		}
		jp.add(jl);
		jp.add(box);
		JPanel jp3 = new JPanel();
		JLabel jl3 = new JLabel("进价：");
		jp3.add(jl3);
		jp3.add(cinprice);
		JLabel jl4 = new JLabel("售价：");
		jp3.add(jl4);
		jp3.add(coutprice);
		JPanel jp5 = new JPanel();
		JLabel jl5 = new JLabel("仓库警戒数量");
		jp5.add(jl5);
		jp5.add(cwarning);
		JPanel jp6 = new JPanel();
		jp6.add(addbtn);
		jp6.add(resetbtn);
		
		addPanel.add(jp1);
		addPanel.add(jp2);
		addPanel.add(jp);
		addPanel.add(jp3);
		addPanel.add(jp5);
		addPanel.add(jp6);
		
		p.add("商品添加",addPanel);
	}
	
	
	private void delPane(JTabbedPane p){
		delPanel = new JPanel();
		delPanel.setLayout(new BoxLayout(delPanel, BoxLayout.Y_AXIS));
		cid2 = new JTextField(20);
		sortbtn2 = new JButton("搜索");
		delbtn2 = new JButton("删除");
		resetbtn2 = new JButton("重置");
		info2 = new JTextArea(20,4);
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("商品编号：");
		jp1.add(jl1);
		jp1.add(cid2);
		JPanel jp2 = new JPanel();
		jp2.add(sortbtn2);
		JPanel jp3 = new JPanel();
		jp3.add(info2);
		JPanel jp4 = new JPanel();
		jp4.add(delbtn2);
		jp4.add(resetbtn2);
		
		delPanel.add(jp1);
		delPanel.add(jp2);
		delPanel.add(jp3);
		delPanel.add(jp4);
		
		p.add("商品删除",delPanel);
	}
	
	private void modPane(JTabbedPane p){
		modPanel = new JPanel();
		modPanel.setLayout(new BoxLayout(modPanel, BoxLayout.Y_AXIS));
		cid3 =  new JTextField(20);
		cinprice3 = new JTextField(7);
		coutprice3 = new JTextField(7);
		cwarning3 = new JTextField(10);
		sortbtn3 = new JButton("搜索");
		modbtn3 = new JButton("修改");
		resetbtn3 = new JButton("重置");
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("商品编号");
		jp1.add(jl1);
		jp1.add(cid3);
		JPanel jp = new JPanel();
		jp.add(sortbtn3);
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("进价");
		JLabel jl3 = new JLabel("售价");
		jp2.add(jl2);
		jp2.add(cinprice3);
		jp2.add(jl3);
		jp2.add(coutprice3);
		JPanel jp3 = new JPanel();
		JLabel jl4 = new JLabel("警戒值");
		jp3.add(jl4);
		jp3.add(cwarning3);
		JPanel jp4 = new JPanel();
		jp4.add(modbtn3);
		jp4.add(resetbtn3);
		
		modPanel.add(jp1);
		modPanel.add(jp);
		modPanel.add(jp2);
		modPanel.add(jp3);
		modPanel.add(jp4);
		
		p.add("商品修改",modPanel);
	}
	
	
	/**以下都是一些平常函数*/
	public String getAddNameText(){
		return cname.getText().trim();
	}
	
	public String getAddStyleText(){
		return cstyle.getText().trim();
	}
	
	public double getAddInpriceNum(){
		return cinprice.getText().trim().length()==0?0:Double.parseDouble(cinprice.getText().trim());
	}
	
	public double getAddOutpriceNum(){
		return coutprice.getText().trim().length()==0?0:Double.parseDouble(coutprice.getText().trim());
	}
	
	public String  getAddWarningNum(){
		return cwarning.getText().trim();
	}
	
	public String getDelIdText(){
		return cid2.getText().trim();
	}
	
	public String getModIdText(){
		return cid3.getText().trim();
	}
	
	public double getModInpriceNum(){
		return cinprice3.getText().trim().length()==0?0:Double.parseDouble(cinprice3.getText().trim());
	}
	
	public double getModOutpriceNum(){
		return coutprice3.getText().trim().length()==0?0:Double.parseDouble(coutprice3.getText().trim());
	}
	
	public String getModWarningNum(){
		return cwarning.getText().trim();
	}
	
	public void setCatelist(ArrayList<String> list){
		cateList = list;
	}
	
	public void resetAdd(){
		cname.setText(null);
		cstyle.setText(null);
		cinprice.setText(null);
		coutprice.setText(null);
		cwarning.setText(null);
	}
	
	public void resetDel(){
		cid2.setText(null);
	}
	
	public void resetMod(){
		cid3.setText(null);
		cinprice3.setText(null);
		coutprice3.setText(null);
		cwarning3.setText(null);
	}
	
	public String getBox(){
		return boxString;
	}
	
	public void setDelPanelInfo(String s,boolean type){
		info2.setText(s);
		delbtn2.setEnabled(type);
	}
	
	public void setModPanelInfo(String inprice,String outprice,String warning){
		cinprice3.setText(inprice);
		coutprice3.setText(outprice);
		cwarning3.setText(warning);
	}
	
}
