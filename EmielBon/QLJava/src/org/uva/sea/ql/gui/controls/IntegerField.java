package org.uva.sea.ql.gui.controls;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.eval.IntegerValue;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.gui.State;

public class IntegerField extends TextField {

	public IntegerField(Identifier identifier, State state) {
		super(identifier, state);
		setText("0");
	}
	
	public boolean isValid() {
		try {
			textToValue();
		} catch(NumberFormatException ex) {
			return false;
		}
		return true;
	}

	public Value textToValue() {
		return new IntegerValue(Integer.parseInt(getText()));
	}

}
