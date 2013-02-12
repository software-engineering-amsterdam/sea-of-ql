package org.uva.sea.ql.visitor.eval.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Int implements Widget {

	private final JTextField component;

	public Int() {
		this.component = new JTextField(10);
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
}
