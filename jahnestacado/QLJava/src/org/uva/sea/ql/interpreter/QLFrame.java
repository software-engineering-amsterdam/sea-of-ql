package org.uva.sea.ql.interpreter;

import javax.swing.JFrame;

public class QLFrame {
	private final JFrame frame;
	
	public QLFrame(){
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public JFrame getQLFrame(){
		return frame;
	}

}
