package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import java.awt.Color;

import javax.swing.border.LineBorder;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Doub;
import org.uva.sea.ql.questionnaire.State;

public class DoubleControl extends KeyControl {

	//control with text field and the possibility to enter int values
	public DoubleControl(State state, Ident ident) {
		super(state, ident);
		initEventListener();
	}

	@Override
	public String toString() {
		return "DoubleControl Ident(" + this.ident.toString() + ")";
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
