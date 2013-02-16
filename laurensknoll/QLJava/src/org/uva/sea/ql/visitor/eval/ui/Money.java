package org.uva.sea.ql.visitor.eval.ui;

import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Money implements Widget {

	private final JTextField component;

	public Money() {
		this.component = new JTextField(10);
	}

	@Override
	public JComponent getComponent() {
		return this.component;
	}

	@Override
	public void setValue(AbstractValue value) {
		// The semantic check guarantees that this is a Money.
		org.uva.sea.ql.visitor.eval.value.Money valueAsMoney = (org.uva.sea.ql.visitor.eval.value.Money) value;
		BigDecimal amount = valueAsMoney.getValue();
		this.component.setText(NumberFormat.getCurrencyInstance()
				.format(amount));
	}

}
