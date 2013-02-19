package org.uva.sea.ql.rendering.controls;

import org.uva.sea.ql.evaluation.values.Int;
import org.uva.sea.ql.evaluation.values.Value;

public class IntegerField extends Field {

	@Override
	public Value getValue() {
		return new Int(Integer.parseInt(jTextField.getText()));
	}	

}
