package org.uva.sea.ql.ast.types;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class IntType extends Type implements ActionListener, FocusListener {

	private JTextField answerField;
	
	@Override
	public String toString() {
		return "Integer";
	}
	
	@Override
	public JComponent getAnswerField(boolean enabled) {
		answerField = new JTextField();
		answerField.setEnabled(enabled);
		answerField.addActionListener(this);
		answerField.addFocusListener(this);
		return answerField;
	}


	@Override
	public boolean hasValue() {
		return isValidInteger();
	}
	
	@Override
	public Value getAnswerFieldValue(JComponent answerComponent) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		eventUpdate(e);
	}
	
	@Override
	public void focusGained(FocusEvent e) {	
	}

	@Override
	public void focusLost(FocusEvent e) {
		eventUpdate(e);
	}
	
	public void eventUpdate(AWTEvent e) {
		if (e.getSource() == answerField) {
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
	}
}
