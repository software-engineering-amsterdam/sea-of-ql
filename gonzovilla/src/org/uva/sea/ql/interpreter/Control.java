package org.uva.sea.ql.interpreter;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.values.Value;

public abstract class Control {
	
	public abstract Value getValue();
	public abstract JComponent getControl();
	public abstract void setValue(Value value);
	public abstract void addListener(ObservableQuestion observableQuestion);
	
}
