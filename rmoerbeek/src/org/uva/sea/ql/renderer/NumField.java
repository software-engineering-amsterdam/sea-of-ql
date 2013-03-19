package org.uva.sea.ql.renderer;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.evaluator.values.Value;
import org.uva.sea.ql.evaluator.values.IntValue;

public class NumField extends Control {
	
	private final JTextField numField;
	
	public NumField() {
		this.numField = new JTextField("", 9);
		
	}

	@Override
	public void setValue(Value val) {
		if (new IntValue(1).getClass() == val.getClass()) {
		numField.setText(((IntValue) val).getValue().toString());
		}
	}

	@Override
	public Value getValue() {
		return new IntValue(Integer.parseInt(numField.getText()));
	}

	@Override
	public void setVisible(boolean v) {
		numField.setVisible(v);	
	}

	@Override
	public JComponent getControl() {
		return numField;
	}

	@Override
	public void addListener(QuestionObservable qo) {
		numField.addActionListener(qo);
	}

}
