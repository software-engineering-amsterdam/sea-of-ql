package org.uva.sea.ql.interpreter;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.values.Int;


public class IntField extends Control {

	protected final JTextField jIntField;

	public IntField(){
		jIntField = new JTextField();
	}
	
	@Override
	public JComponent getControl() {
		return jIntField;
	}

	@Override
	public void setValue(Value value) {
		jIntField.setText(((Int)value).getValue().toString());	
	}

	@Override
	public Value getValue() {
		if (jIntField.getText().isEmpty())
			return new Int(0);
		
		try{
			return new Int(Integer.parseInt(jIntField.getText()));
		}catch	(NumberFormatException e)	{
			//new ErrorWindow("This field accepts only integer values");
			System.out.println("This field accepts only integer values");
			return new Int(0);
		}
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
