package org.uva.sea.ql.visitor.eval.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class String implements Widget {

	private final JTextField component;

	public String() {
		this.component = new JTextField(30);
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
}
