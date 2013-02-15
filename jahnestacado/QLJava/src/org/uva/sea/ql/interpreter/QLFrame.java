package org.uva.sea.ql.interpreter;

import java.awt.Dimension;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

public class QLFrame {
	private final JFrame frame;
	
	public QLFrame(JFrame frame){
		this.frame=frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new MigLayout("fill"));
		frame.setSize(new Dimension (700,500));
		frame.setResizable(true);       
	}
	
	public static JFrame createQLFrame(){
		QLFrame frame=new QLFrame(new JFrame());
		return frame.getJFrame();
	}
	
	private JFrame getJFrame(){
		return frame;
	}
	
	
  
}
