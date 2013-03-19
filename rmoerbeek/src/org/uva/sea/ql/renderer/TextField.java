package org.uva.sea.ql.renderer;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.evaluator.values.Value;
import org.uva.sea.ql.evaluator.values.StringValue;

public class TextField extends Control {
	
	private final JTextField textField;
	
	public TextField() {
		this.textField = new JTextField("", 20);
		
	}

	@Override
	public void setValue(Value val) {
		textField.setText(((StringValue) val).getValue());
	}

	@Override
	public Value getValue() {
		return new StringValue(textField.getText());
	}

	@Override
	public void setVisible(boolean b) {
		textField.setVisible(b);	
	}

	@Override
	public JComponent getControl() {
		return textField;
	}

	@Override
	public void addListener(QuestionObservable qo) {
		textField.addActionListener(qo);
		
	}

}
