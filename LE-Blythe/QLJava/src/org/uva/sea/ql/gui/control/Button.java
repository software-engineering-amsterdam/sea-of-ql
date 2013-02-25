package org.uva.sea.ql.gui.control;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Button extends Control {

	private JButton button;


	public Button(String text){
		button = new JButton(text);
	}
	
	
	public void addActionListener(ActionListener l){
		button.addActionListener(l);
	}
	
	
	@Override
	protected JComponent getComponent() {
		return button;
	}

	@Override
	public void setVisible(boolean b) {
		button.setVisible(b);
	}
	
	
}
