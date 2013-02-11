package org.uva.sea.ql.visitor.eval.ui;

import javax.swing.JComponent;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public interface Widget {

	public JComponent getComponent();

	public void setValue(AbstractValue value);

}
