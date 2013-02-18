package org.uva.sea.ql.rendering.controls;

import org.uva.sea.ql.evaluation.values.Value;

public class TextField extends Field {

	@Override
	public Value getValue() {
		return new org.uva.sea.ql.evaluation.values.String(jTextField.getText());
	}

}
