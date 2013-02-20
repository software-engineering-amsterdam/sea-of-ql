package org.uva.sea.ql.rendering.controls;

import org.uva.sea.ql.evaluation.values.Int;
import org.uva.sea.ql.evaluation.values.Value;

public class IntegerField extends Field {

	@Override
	public Value getValue() {
		String text = jTextField.getText();
		if (text.isEmpty())
			return new Int(0);
		return new Int(Integer.parseInt(jTextField.getText()));
	}

	@Override
	public void setValue(Value value) {
		if (value instanceof Int)
			jTextField.setText(((Int)value).getValue().toString());		
	}	

}
