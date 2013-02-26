package org.uva.sea.ql.gui.control;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Label extends Control {

	private JLabel label;
	
	public Label(){
		this.label = new JLabel();
	}
	
	
	public Label(String text){
		this.label = new JLabel(text);
	}

	
	public void setText(String text){
		this.label.setText(text);
	}
	
	
	@Override
	protected JComponent getComponent() {
		return label;
	}

	@Override
	public void setVisible(boolean b) {
		label.setVisible(b);
	}
}
