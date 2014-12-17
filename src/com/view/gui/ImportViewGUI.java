package com.view.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ImportViewGUI extends JInternalFrame{
	private JTabbedPane pane;
	private JTextField idField,warehouseField,operatorField,descField,totalField;
	private JComboBox<String> box;
	private String type;
	private JButton getIdButton,addItemButton,addButton;
	
	
	public ImportViewGUI(){
		super("������", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
	}

	private JTabbedPane createTabbedPane() {
		// TODO Auto-generated method stub
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("���");
		idField = new JTextField(10);
		getIdButton = new JButton("����id");
		jp1.add(jl1);
		jp1.add(idField);
		jp1.add(getIdButton);
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("����");
		box = new JComboBox<String>();
		box.addItem("������");
		box.addItem("�˻���");
		box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					type = (String)box.getSelectedItem();
				}
			}
		});
		
		JPanel jp3 = new JPanel();
		JLabel jl3 = new JLabel("�ֿ�");
		JLabel jl4 = new JLabel("����Ա");
		jp3.add(jl3);
		jp3.add(warehouseField);
		jp3.add(jl4);
		jp3.add(operatorField);
		
		
		JPanel jp4 = new JPanel();
		JLabel jl5 = new JLabel("��Ʒ�б�");
		JLabel jl7 = new JLabel("�ܶ�");
		jp4.add(jl5);
		addItemButton = new JButton("�����Ӹ���");
		jp4.add(jl7);
		jp4.add(totalField);
		jp4.add(addItemButton);
		
		JPanel jp5 = new JPanel();
		JLabel jl6 = new JLabel("��ע");
		jp5.add(jl6);
		jp5.add(descField);
		
		JPanel jp6 = new JPanel();
		jp6.add(addButton);
		
		
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		jp.add(jp4);
		jp.add(jp5);
		jp.add(jp6);
		
		pane.add("��ӽ�����",jp);
		
		
		return pane;
	}
	
	public void addImportListener(ActionListener[]a){
		
	}
	
	public String getId(){
		return idField.getText().trim();
	}
	
	public String getType(){
		return type;
	}
	
	public String getWarehouse(){
		return warehouseField.getText().trim();
	}
	
	public void setOperator(String s){
		operatorField.setText(s);
	}
	
	public void setTotal(String s){
		totalField.setText(s);
	}
	
	public String getDesc(){
		return descField.getText().trim();
	}
	
}
