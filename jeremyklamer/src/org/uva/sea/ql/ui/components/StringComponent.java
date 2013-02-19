package org.uva.sea.ql.ui.components;

import javax.swing.JTextField;

import org.uva.sea.ql.interpreter.StringVal;
import org.uva.sea.ql.interpreter.Value;

public class StringComponent extends ActiveComponent{
	
	private final static int UI_COMPONENT_WIDTH = 150;
	
	public StringComponent() {
		super("wrap, width :"+ UI_COMPONENT_WIDTH + ":", new JTextField());
		answerField.setSize(UI_COMPONENT_WIDTH, answerField.getHeight());
	}

	@Override
	public void updateValue(Value newValue) {
		((JTextField)answerField).setText(((StringVal)newValue).getValue());
	}

	@Override
	public Value getValue() {
		return new StringVal(((JTextField)answerField).getText());
	}
}
