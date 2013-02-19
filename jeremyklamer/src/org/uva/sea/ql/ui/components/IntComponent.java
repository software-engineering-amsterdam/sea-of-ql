package org.uva.sea.ql.ui.components;

import javax.swing.JTextField;

import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class IntComponent extends ActiveComponent{

	private final static int UI_COMPONENT_WIDTH = 100;
	
	public IntComponent() {
		super("wrap, width :"+ UI_COMPONENT_WIDTH + ":", new JTextField());
	}
	
	@Override
	public void updateValue(Value newValue) {
		((JTextField)answerField).setText("" + ((IntVal)newValue).getValue());
	}
	
	@Override
	public Value getValue() {
		return new IntVal(Integer.parseInt(((JTextField)answerField).getText()));
	}

}
