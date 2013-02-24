package org.uva.sea.ql.visitor.eval.ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Undefined;

public class String extends Widget implements DocumentListener {

	private final Box component;
	private final JTextField textField;

	public String() {
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
			// The semantic check guarantees that this is a String.
			org.uva.sea.ql.visitor.eval.value.String valueAsString = (org.uva.sea.ql.visitor.eval.value.String) value;
			this.textField.setText(valueAsString.getValue());
		}

		this.propagateChange();

		this.textField.getDocument().addDocumentListener(this);
	}

	@Override
	public AbstractValue getValue() {
		java.lang.String value = this.textField.getText();
		return new org.uva.sea.ql.visitor.eval.value.String(value);
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
