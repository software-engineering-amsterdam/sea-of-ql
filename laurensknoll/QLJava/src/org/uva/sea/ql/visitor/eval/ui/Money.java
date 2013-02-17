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
		this.component = new JTextField();
		this.component.setText(NumberFormat.getCurrencyInstance().format(0.00));

		// Listener must be added after the initial text is set to prevent
		// propagation.
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

		// JTextField.setText() fires a remove and insert event.
		// We however only want to trigger an update once.
		// Therefore we remove the eventlistener and add it
		// after the change is made.
		this.component.getDocument().removeDocumentListener(this);

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		java.lang.String valueAsString = numberFormat.format(valueAsMoney
				.getValue());
		this.component.setText(valueAsString);

		this.propagateChange();

		this.component.getDocument().addDocumentListener(this);
	}

	@Override
	public AbstractValue getValue() {
		java.lang.String value = this.component.getText();

		Number number = 0;
		try {
			number = NumberFormat.getCurrencyInstance().parse(value);
		} catch (ParseException e) {
			// Sadly this cannot be dealt with, with an if-else.
		}

		return new org.uva.sea.ql.visitor.eval.value.Money(new BigDecimal(
				number.longValue()));
	}

	@Override
	public void setReadOnly(boolean isReadOnly) {
		this.component.setEnabled(!isReadOnly);
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// When attributes change there is no need to propagate.
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		this.propagateChange();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		this.propagateChange();
	}

	private void propagateChange() {
		this.setChanged();
		this.notifyObservers();
	}

}
