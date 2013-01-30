package org.uva.sea.ql.ast.types;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class IntType extends Type implements ActionListener {

	private TextField answerField;
	
	@Override
	public String toString() {
		return "Integer";
	}
	
	@Override
	public Component getAnswerField(boolean enabled) {
		answerField = new TextField();
		answerField.setEnabled(enabled);
		answerField.addActionListener(this);
		return answerField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isValidInteger()) {
			if (form != null) {
				form.eval();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "The value should be an Integer!");
			answerField.setText("");
		}
	}

	@Override
	public boolean hasValue() {
		return isValidInteger();
	}
	
	@Override
	public Value getAnswerFieldValue(Component answerComponent) {
		return getValue();
	}
	
	@Override
	public void setAnswerFieldValue(Value value) {
		if (value.getClass().equals(new IntValue().getClass())) {
			answerField.setText(((IntValue)value).getValue().toString());
		}
		else {
			throw new IllegalArgumentException("The value given is not of the type Int");
		}
	}
	
	@Override
	public Value getDefaultValue() {
		return new IntValue();
	}
	
	private boolean isValidInteger() {
		try {
			Integer.parseInt(answerField.getText());
		}
		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private IntValue getValue() {
		if(isValidInteger())
			return new IntValue(Integer.parseInt(answerField.getText()));
		return new IntValue();
	}
}
