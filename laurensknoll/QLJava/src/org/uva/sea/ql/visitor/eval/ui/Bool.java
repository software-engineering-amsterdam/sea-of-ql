package org.uva.sea.ql.visitor.eval.ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Bool extends Widget implements ItemListener {

	private final JCheckBox component;

	public Bool() {
		this.component = new JCheckBox();
		this.component.addItemListener(this);
	}

	@Override
	public JComponent getComponent() {
		return this.component;
	}

	@Override
	public AbstractValue getValue() {
		return new org.uva.sea.ql.visitor.eval.value.Bool(
				this.component.isSelected());
	}

	@Override
	public void setValue(AbstractValue value) {
		// The semantic check guarantees that this is a Bool.
		org.uva.sea.ql.visitor.eval.value.Bool valueAsBool = (org.uva.sea.ql.visitor.eval.value.Bool) value;
		this.component.setSelected(valueAsBool.getValue());
	}

	@Override
	public void setReadOnly(boolean isReadOnly) {
		this.component.setEnabled(!isReadOnly);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		this.setChanged();
		this.notifyObservers();
	}

}
