package org.uva.sea.ql.gui.controls;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.eval.MoneyValue;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.interpreter.State;

public class MoneyField extends TextField {

	public MoneyField(Identifier identifier, State state) {
		super(identifier, state);
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
		return new MoneyValue(Float.parseFloat(getText()));
	}
	
}
