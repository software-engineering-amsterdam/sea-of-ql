package org.uva.sea.ql.visitor.eval.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class String extends Widget implements DocumentListener {

	private final JTextField component;

	public String() {
		this.component = new JTextField(30);
		this.component.getDocument().addDocumentListener(this);
	}

	@Override
	public JComponent getComponent() {
		return this.component;
	}

	@Override
	public void setValue(AbstractValue value) {
		// TODO: Implement.
		throw new NotImplementedException();
	}

	@Override
	public AbstractValue getValue() {
		// TODO: Implement.
		throw new NotImplementedException();
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
