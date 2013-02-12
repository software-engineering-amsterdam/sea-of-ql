package org.uva.sea.ql.visitor.eval.ui;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Bool implements Widget {

	private final JCheckBox component;

	public Bool() {
		this.component = new JCheckBox();
	}

	@Override
	public JComponent getComponent() {
		return this.component;
	}

	@Override
	public void setValue(AbstractValue value) {
		// The semantic check guarantees that this is a Bool.
		org.uva.sea.ql.visitor.eval.value.Bool valueAsBool = (org.uva.sea.ql.visitor.eval.value.Bool) value;
		this.component.setSelected(valueAsBool.getValue());
	}

}
