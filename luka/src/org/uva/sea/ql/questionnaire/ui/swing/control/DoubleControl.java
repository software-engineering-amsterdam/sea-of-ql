package org.uva.sea.ql.questionnaire.ui.swing.control;

import java.awt.Color;

import javax.swing.border.LineBorder;

import org.uva.sea.ql.ast.nodes.values.Doub;
import org.uva.sea.ql.questionnaire.state.State;

public class DoubleControl extends KeyControl {

	public DoubleControl(State state) {
		super(state);
	}

	@Override
	protected void handleKeyPressed(String input) {
		try {
			Doub value = new Doub(Double.valueOf(input));
			setValue(value);
			this.controlPanel.setBorder(javax.swing.BorderFactory
					.createEmptyBorder());
		} catch (NumberFormatException e) {
			this.controlPanel.setBorder(new LineBorder(Color.red));
		}

	}

}
