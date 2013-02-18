package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.questionnaire.state.State;

public class TextControl extends KeyControl {

	public TextControl(State state,Ident ident) {
		super(state, ident);
		initEventListener();
	}

	@Override
	protected void handleKeyPressed(String input) {
		Str value = new Str(input);
		setValue(value);
	}

}
