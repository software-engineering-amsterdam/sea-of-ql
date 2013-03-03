package org.uva.sea.ql.gui;

import java.awt.Component;

import org.uva.sea.ql.ast.Value;

public abstract class Control {

	public abstract Value getValue();

	public abstract Component getComponent();

	public abstract void listener(ObservableSimpleQuestion observable);

	public abstract void setValueOfComponent(Value value);

}
