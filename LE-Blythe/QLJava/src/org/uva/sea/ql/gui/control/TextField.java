package org.uva.sea.ql.gui.control;

import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class TextField extends Control {

	private JTextField textfield;

	public TextField(){
		this.textfield = new JTextField();
	}
	
	
	public void addKeyListener(KeyListener l) {
		textfield.addKeyListener(l);
	}

	
	public String getText(){
		return textfield.getText();
	}
	
	
	@Override
	protected JComponent getComponent() {
		return textfield;
	}
	
	@Override
	public void setVisible(boolean b) {
		textfield.setVisible(b);
	}
}
