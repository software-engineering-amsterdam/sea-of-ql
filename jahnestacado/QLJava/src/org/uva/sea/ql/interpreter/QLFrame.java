package org.uva.sea.ql.interpreter;

import java.awt.Dimension;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

public class QLFrame {
	private final JFrame frame;
	
	public QLFrame(){
		this.frame=new JFrame();
		setSettings();
	}
	
	public static JFrame createQLFrame(){
		QLFrame frame=new QLFrame();
		return frame.getJFrame();
	}
	
	private JFrame getJFrame(){
		return frame;
	}
	
	private void setSettings(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new MigLayout("fill"));
		frame.setSize(new Dimension (700,500));
		frame.setResizable(false);   
	}
	
	
  
}
