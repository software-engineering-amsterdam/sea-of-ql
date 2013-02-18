package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import java.awt.Color;

import javax.swing.border.LineBorder;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.UndefinedValue;
import org.uva.sea.ql.questionnaire.state.State;

public class IntControl extends KeyControl {

	public IntControl(State state, Ident ident) {
		super(state, ident);
		initEventListener();
	}

	@Override
	protected void handleKeyPressed(String input) {
		try {
			Int value = new Int(Integer.valueOf(input));
			setValue(value);
			this.controlPanel.setBorder(javax.swing.BorderFactory
					.createEmptyBorder());
		} catch (NumberFormatException e) {
			setValue(new UndefinedValue());
			this.controlPanel.setBorder(new LineBorder(Color.red));
		}
	}

}
