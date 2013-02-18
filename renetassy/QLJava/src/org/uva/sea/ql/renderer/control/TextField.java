package org.uva.sea.ql.renderer.control;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.values.Str;
import org.uva.sea.ql.values.Value;

public class TextField extends Control {

	final int TEXTFIELD_SIZE = 15; 
	
	private final JTextField widget;
	
	public TextField () {
		widget = new JTextField();
	}
	
	@Override
	public Value getValue() {
		return new Str(widget.getText());
	}

	@Override
	public JComponent getWidget() {
		return new JTextField(TEXTFIELD_SIZE);
	}

}
