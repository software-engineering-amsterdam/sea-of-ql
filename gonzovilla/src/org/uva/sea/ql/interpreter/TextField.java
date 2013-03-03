package org.uva.sea.ql.interpreter;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.StringValue;
import org.uva.sea.ql.ast.values.Value;

public class TextField extends Control {
	
	protected final JTextField jTextField;

	protected TextField() {
		jTextField = new JTextField(20);
	}
	@Override
	public JComponent getControl() {
		return jTextField;
	}

	@Override
	public void setValue(Value value) {
		if (value instanceof StringValue)
		jTextField.setText(((StringValue)value).getValue());	
	}

	@Override
	public Value getValue() {
		return new StringValue(jTextField.getText());
	}

	@Override
	public void addListener(ObservableQuestion observableQuestion) {
		jTextField.addActionListener(observableQuestion);
		jTextField.addFocusListener(observableQuestion);		
	}
	@Override
	public void addListener(ObservableComputed observableComputed) {
		jTextField.addActionListener(observableComputed);
		jTextField.addFocusListener(observableComputed);
	}

}
