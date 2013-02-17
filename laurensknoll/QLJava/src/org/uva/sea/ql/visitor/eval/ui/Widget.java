package org.uva.sea.ql.visitor.eval.ui;

import java.util.Observable;

import javax.swing.JComponent;

import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public abstract class Widget extends Observable {

	public abstract JComponent getComponent();

	public abstract void setValue(AbstractValue value);

	public abstract AbstractValue getValue();

	public abstract void setReadOnly(boolean isReadOnly);

}
