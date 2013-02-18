package org.uva.sea.ql.questionnaire.ui.swing.control;

import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.questionnaire.state.State;

public class TextControl extends KeyControl {

	public TextControl(State state) {
		super(state);
	}

	@Override
	protected void handleKeyPressed(String input) {
		Str value = new Str(input);
		setValue(value);
	}

}
