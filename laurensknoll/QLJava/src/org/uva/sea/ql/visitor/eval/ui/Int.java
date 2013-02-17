package org.uva.sea.ql.visitor.eval.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Int extends Widget implements DocumentListener {

	private final JTextField component;

	public Int() {
		this.component = new JTextField(10);
		this.component.setText("0");
		this.component.getDocument().addDocumentListener(this);
	}

	@Override
	public JComponent getComponent() {
		return this.component;
	}

	@Override
	public void setValue(AbstractValue value) {
		// The semantic check guarantees that this is a Int.
		org.uva.sea.ql.visitor.eval.value.Int valueAsInt = (org.uva.sea.ql.visitor.eval.value.Int) value;
		this.component.setText(java.lang.String.format("%d",
				valueAsInt.getValue()));
	}

	@Override
	public AbstractValue getValue() {
		java.lang.String value = this.component.getText();
		int i = Integer.parseInt(value);
		return new org.uva.sea.ql.visitor.eval.value.Int(i);
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		this.setChanged();
		this.notifyObservers();
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
