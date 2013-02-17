package org.uva.sea.ql.visitor.eval.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class String extends Widget implements DocumentListener {

	private final JTextField component;

	public String() {
		this.component = new JTextField();
		this.component.getDocument().addDocumentListener(this);
	}

	@Override
	public JComponent getComponent() {
		return this.component;
	}

	@Override
	public void setValue(AbstractValue value) {
		// The semantic check guarantees that this is a String.
		this.updateValueInGUI((org.uva.sea.ql.visitor.eval.value.String) value);
	}

	private void updateValueInGUI(org.uva.sea.ql.visitor.eval.value.String value) {
		// JTextField.setText() fires a remove and insert event.
		// We however only want to trigger an update once.
		// Therefore we remove the eventlistener and add it
		// after the change is made.
		this.component.getDocument().removeDocumentListener(this);

		this.component.setText(value.getValue());

		this.propagateChange();

		this.component.getDocument().addDocumentListener(this);
	}

	@Override
	public AbstractValue getValue() {
		java.lang.String value = this.component.getText();
		return new org.uva.sea.ql.visitor.eval.value.String(value);
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
