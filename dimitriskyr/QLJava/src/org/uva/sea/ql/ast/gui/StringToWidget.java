package org.uva.sea.ql.ast.gui;

import java.awt.Component;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.values.String_lit;

public class StringToWidget extends Fields {

	private JTextField textfield;

	@Override
	public Value getValue() {
		return new String_lit(textField.getText());
	}

	@Override
	public Component getComponent() {
		return textField;
	}

	@Override
	public void Listener(ObservableQuestion observable) {
		textField.addActionListener(observable);
	}

	@Override
	public void setValueOfComponent(Value value) {
		textfield.setText(value.toString());
	}
}
