package org.uva.sea.ql.gui.control;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Frame extends Control{

	private JFrame frame;
	private JComponent rootComponent;
	
	public Frame(Control ctrl, String title, int width, int height){
		frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);	
		
		rootComponent = ctrl.getComponent();
		frame.getContentPane().add(rootComponent);
	}
	
	@Override
	protected JComponent getComponent() {
		return rootComponent;
	}

	@Override
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

}
