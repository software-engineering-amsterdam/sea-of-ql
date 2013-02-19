package org.uva.sea.ql.ui.components;

import javax.swing.JCheckBox;

import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Value;


public class BoolComponent extends ActiveComponent {
	
	public BoolComponent() {
		super("wrap", new JCheckBox());	
	}
	
	@Override
	public void updateValue(Value newValue) {
		((JCheckBox)answerField).setSelected(((BoolVal)newValue).getValue());
	}

	@Override
	public Value getValue() {
		return new BoolVal(((JCheckBox)answerField).isSelected());
	}
	
}
