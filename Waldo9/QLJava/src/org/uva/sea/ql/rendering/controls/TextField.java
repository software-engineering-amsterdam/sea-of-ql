package org.uva.sea.ql.rendering.controls;

import org.uva.sea.ql.evaluation.values.Value;

public class TextField extends Field {

	@Override
	public Value getValue() {
		return new org.uva.sea.ql.evaluation.values.String(jTextField.getText());
	}

	@Override
	public void setValue(Value value) {
		if (value instanceof org.uva.sea.ql.evaluation.values.String)
			jTextField.setText(((org.uva.sea.ql.evaluation.values.String)value).getValue());		
	}

}
