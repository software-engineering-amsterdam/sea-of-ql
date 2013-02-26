package org.uva.sea.ql.ast.gui;

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
	public void Listener(ObservableQuestion observable) {
		textField.addActionListener(observable);
		textField.addFocusListener(observable);
	}

}
