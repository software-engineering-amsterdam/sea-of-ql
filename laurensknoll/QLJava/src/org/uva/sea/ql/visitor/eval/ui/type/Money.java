package org.uva.sea.ql.visitor.eval.ui.type;

import java.awt.Dimension;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Undefined;

public class Money extends Widget implements DocumentListener {

	private final Box component;
	private final JTextField textField;

	public Money() {
		this.component = Box.createVerticalBox();
		this.component.add(Box.createVerticalGlue());

		this.textField = new JTextField();
		Dimension minimal = this.textField.getMinimumSize();
		this.textField.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				minimal.height));
		this.textField.getDocument().addDocumentListener(this);

		this.component.add(this.textField);
		this.component.add(Box.createVerticalGlue());
	}

	private NumberFormat getMoneyNumberFormat() {
		NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		return format;
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
		this.textField.getDocument().removeDocumentListener(this);

		if (value.equals(Undefined.UNDEFINED)) {
			this.textField.setText("");
		} else {
			// The semantic check guarantees that this is a Money.
			org.uva.sea.ql.visitor.eval.value.Money money = (org.uva.sea.ql.visitor.eval.value.Money) value;
			BigDecimal display = money.getValue().setScale(2,
					org.uva.sea.ql.visitor.eval.value.Money.ROUNDING_MODE);

			NumberFormat numberFormat = this.getMoneyNumberFormat();
			this.textField.setText(numberFormat.format(display));
		}

		this.propagateChange();

		this.textField.getDocument().addDocumentListener(this);
	}

	@Override
	public AbstractValue getValue() {
		java.lang.String value = this.textField.getText();

		NumberFormat numberFormat = this.getMoneyNumberFormat();
		Number number = null;
		try {
			number = numberFormat.parse(value);
		} catch (ParseException e) {
			return Undefined.UNDEFINED;
		}

		try {
			BigDecimal d = new BigDecimal(number.doubleValue());
			return new org.uva.sea.ql.visitor.eval.value.Money(d);
		} catch (NumberFormatException ex) {
			return Undefined.UNDEFINED;
		}
	}

	@Override
	public void setReadOnly(boolean isReadOnly) {
		this.textField.setEnabled(!isReadOnly);
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
