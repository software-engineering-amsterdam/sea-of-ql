package org.uva.sea.ql.gui;

import java.awt.Component;

import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.values.Money;

public class MoneyToWidget extends Fields {

	public MoneyToWidget(){
		super();
	}
	
	@Override
	public Value getValue() {
		return new Money(Float.parseFloat(textField.getText()));
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
		String values = "" + (((Money) value).getValue());
		textField.setText(values);
	}

}
