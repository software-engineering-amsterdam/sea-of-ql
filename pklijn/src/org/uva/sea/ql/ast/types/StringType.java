package org.uva.sea.ql.ast.types;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.uva.sea.ql.ast.values.StringValue;
import org.uva.sea.ql.ast.values.Value;

public class StringType extends Type implements ActionListener {

	private TextField answerField;
	
	@Override
	public String toString() {
		return "String";
	}

	@Override
	public Component getAnswerField(boolean enabled) {
		answerField = new TextField();
		answerField.setEnabled(enabled);
		answerField.addActionListener(this);
		return answerField;
	}

	@Override
	public boolean hasValue() {
		return true;
	}
	
	@Override
	public Value getAnswerFieldValue(Component answerComponent) {
		return new StringValue(answerField.getText());
	}
	
	@Override
	public void setAnswerFieldValue(Value value) {
		if (value.getClass().equals(new StringValue().getClass())) {
			answerField.setText(((StringValue)value).getValue().toString());
		}
		else {
			throw new IllegalArgumentException("The value given is not of the type String");
		}
	}
	
	@Override
	public Value getDefaultValue() {
		return new StringValue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (form != null) {
			form.eval();
		}
	}
}
