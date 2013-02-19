package org.uva.sea.ql.visitor.eval.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Undefined;

public class Int extends Widget implements DocumentListener {

	private final JTextField component;

	public Int() {
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
			// The semantic check guarantees that this is a Int.
			org.uva.sea.ql.visitor.eval.value.Int valueAsInt = (org.uva.sea.ql.visitor.eval.value.Int) value;
			java.lang.String valueAsString = java.lang.String.format("%d",
					valueAsInt.getValue());
			this.component.setText(valueAsString);
		}
		this.propagateChange();

		this.component.getDocument().addDocumentListener(this);
	}

	@Override
	public AbstractValue getValue() {
		java.lang.String value = this.component.getText();

		try {
			int i = Integer.parseInt(value);
			return new org.uva.sea.ql.visitor.eval.value.Int(i);
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
