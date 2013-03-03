package org.uva.sea.ql.gui;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.Value;

public abstract class Fields extends Control {
	protected JTextField textField;

	public Fields() {
		textField = new JTextField();
	}

	@Override
	public abstract Value getValue();

	@Override
	public void listener(ObservableSimpleQuestion observable) {
		textField.addActionListener(observable);
		textField.addFocusListener(observable);
	}

}
