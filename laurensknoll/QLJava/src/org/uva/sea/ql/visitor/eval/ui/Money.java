package org.uva.sea.ql.visitor.eval.ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Money extends Widget implements DocumentListener {

	private final JTextField component;

	public Money() {
		this.component = new JTextField(10);
		this.component.setText(NumberFormat.getCurrencyInstance().format(0.00));
		this.component.getDocument().addDocumentListener(this);
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

	@Override
	public AbstractValue getValue() {
		java.lang.String value = this.component.getText();

		Number number = 0;
		try {
			number = NumberFormat.getCurrencyInstance().parse(value);
		} catch (ParseException e) {
			// TODO: Find out why getText returns an empty string.
			e.printStackTrace();
		}

		return new org.uva.sea.ql.visitor.eval.value.Money(new BigDecimal(
				number.longValue()));
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// When attributes change there is no need to propogate.
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		this.setChanged();
		this.notifyObservers();
	}

}
