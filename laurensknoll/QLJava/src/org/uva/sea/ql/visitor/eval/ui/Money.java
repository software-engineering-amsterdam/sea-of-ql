package org.uva.sea.ql.visitor.eval.ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Undefined;

public class Money extends Widget implements DocumentListener {

	private final JTextField component;

	public Money() {
		this.component = new JTextField();
		this.component.getDocument().addDocumentListener(this);
	}

	@Override
	public JComponent getComponent() {
		return this.component;
	}

	@Override
	public void setValue(AbstractValue value) {
		// JTextField.setText() fires a remove and insert event.
		// We however only want to trigger an update once.
		// Therefore we remove the eventlistener and add it
		// after the change is made.
		this.component.getDocument().removeDocumentListener(this);

		if (value.equals(Undefined.UNDEFINED)) {
			this.component.setText("");
		} else {
			// The semantic check guarantees that this is a Money.
			org.uva.sea.ql.visitor.eval.value.Money money = (org.uva.sea.ql.visitor.eval.value.Money) value;
			BigDecimal display = money.getValue().setScale(2,
					org.uva.sea.ql.visitor.eval.value.Money.ROUNDING_MODE);

			NumberFormat numberFormat = NumberFormat
					.getNumberInstance(Locale.US);
			numberFormat.setMinimumFractionDigits(2);
			numberFormat.setMaximumFractionDigits(2);

			this.component.setText(numberFormat.format(display));
		}

		this.propagateChange();

		this.component.getDocument().addDocumentListener(this);
	}

	@Override
	public AbstractValue getValue() {
		java.lang.String value = this.component.getText();

		try {
			BigDecimal d = new BigDecimal(value);
			return new org.uva.sea.ql.visitor.eval.value.Money(d);
		} catch (NumberFormatException ex) {
			return Undefined.UNDEFINED;
		}
	}

	@Override
	public void setReadOnly(boolean isReadOnly) {
		this.component.setEnabled(!isReadOnly);
	}

	@Override
	public void changedUpdate(DocumentEvent event) {
		// When attributes change there is no need to propagate.
	}

	@Override
	public void insertUpdate(DocumentEvent event) {
		this.propagateChange();
	}

	@Override
	public void removeUpdate(DocumentEvent event) {
		this.propagateChange();
	}

	private void propagateChange() {
		this.setChanged();
		this.notifyObservers();
	}

}
