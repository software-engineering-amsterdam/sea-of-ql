package org.uva.sea.ql.gui;

import java.awt.Component;

import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.values.Int;

public class IntegerToWidget extends Fields {
	
	public IntegerToWidget() {
		super();
	}
	

	@Override
	public Value getValue() {
		return new Int(Integer.parseInt(textField.getText()));
	}

	@Override
	public Component getComponent() {
		return textField;
	}

	@Override
	public void listener(ObservableSimpleQuestion observable) {
		textField.addActionListener(observable);
	}

	@Override
	public void setValueOfComponent(Value value) {
		if (value instanceof Int) {
			String values = "" + (((Int) value).getValue());
			System.out.println(values);
			textField.setText(values);
		}
	}
}
