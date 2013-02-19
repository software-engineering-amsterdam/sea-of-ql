package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.questionnaire.State;

public class TextControl extends KeyControl {

	//control with text field and the possibility to enter string values
	public TextControl(State state, Ident ident) {
		super(state, ident);
		initEventListener();
	}

	@Override
	public String toString() {
		return "TextControl Ident(" + this.ident.toString() + ")";
	}

	@Override
	protected void handleKeyPressed(String input) {
		Str value = new Str(input);
		setValue(value);
	}
}