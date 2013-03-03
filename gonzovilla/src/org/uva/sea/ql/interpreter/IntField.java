package org.uva.sea.ql.interpreter;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.values.Int;


public class IntField extends Control {

	protected final JTextField jIntField;

	public IntField(){
		jIntField = new JTextField(20);
	}
	
	@Override
	public JComponent getControl() {
		return jIntField;
	}

	@Override
	public void setValue(Value value) {
		if (value instanceof Int)
			jIntField.setText(((Int)value).getValue().toString());	
	}

	@Override
	public Value getValue() {
		if (jIntField.getText().isEmpty())
			return new Int(0);
		return new Int(Integer.parseInt(jIntField.getText()));
	}

	@Override
	public void addListener(ObservableQuestion observableQuestion) {
		jIntField.addActionListener(observableQuestion);
		jIntField.addFocusListener(observableQuestion);		
	}

	@Override
	public void addListener(ObservableComputed observableComputed) {
		jIntField.addActionListener(observableComputed);
		jIntField.addFocusListener(observableComputed);
	}

}
