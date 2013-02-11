package org.uva.sea.ql.ast.types;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.StringValue;
import org.uva.sea.ql.ast.values.Value;

public class StringType extends Type implements ActionListener, FocusListener {

	private JTextField answerField;
	
	@Override
	public String toString() {
		return "String";
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
		return (!answerField.getText().equals(""));
	}
	
	@Override
	public Value getAnswerFieldValue(JComponent answerComponent) {
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
		if (e.getSource() == answerField && form != null) {
			form.eval();
		}
	}
}
