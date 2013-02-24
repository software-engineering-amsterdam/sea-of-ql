package org.uva.sea.ql.rendering.controls;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.rendering.ObservableQuestion;

public abstract class Field extends Control {
	
	protected final JTextField jTextField;
	private static final int WIDTH = 15;
	
	protected Field() {
		jTextField = new JTextField(WIDTH);
	}
	
	@Override
	public JComponent getControl() {
		return jTextField;
	}
	
	@Override
	public void addListener(ObservableQuestion observableQuestion) {
		jTextField.addActionListener(observableQuestion);
		jTextField.addFocusListener(observableQuestion);
	}

}
