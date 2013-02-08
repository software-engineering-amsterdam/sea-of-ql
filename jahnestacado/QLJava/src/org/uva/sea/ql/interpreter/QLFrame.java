package org.uva.sea.ql.interpreter;

import javax.swing.JFrame;

public class QLFrame {
	private final JFrame frame;
	
	public QLFrame(JFrame frame){
		this.frame=frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);       
	}
	
	public static JFrame createQLFrame(){
		QLFrame frame=new QLFrame(new JFrame());
		return frame.getJFrame();
	}
	
	private JFrame getJFrame(){
		return frame;
	}
	
	
  
}
