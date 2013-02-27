package org.uva.sea.ql.ast.gui;

import java.awt.Component;

import org.uva.sea.ql.ast.Value;

public abstract class Control {

	public abstract Value getValue();

	public abstract Component getComponent();

	public abstract void Listener(ObservableQuestion observable);

	public abstract void setValueOfComponent(Value value);

}
