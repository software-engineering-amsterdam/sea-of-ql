package org.uva.sea.ql.questionnaire.ui.swing.control.visible;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.questionnaire.State;

public class MoneyControl extends KeyControl {
	private JLabel moneyLabel;

	public MoneyControl(State state,Ident ident) {
		super(state, ident);
		this.moneyLabel = new JLabel("Û");
		this.controlPanel.add(moneyLabel);
		initEventListener();
	}

	@Override
	protected void handleKeyPressed(String input) {
		try {
			Money value = new Money(Double.valueOf(input));
			setValue(value);
			this.controlPanel.setBorder(javax.swing.BorderFactory
					.createEmptyBorder());
		} catch (NumberFormatException e) {
			this.controlPanel.setBorder(new LineBorder(Color.red));
		}

	}

}
