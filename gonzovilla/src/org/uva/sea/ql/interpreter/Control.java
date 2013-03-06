package org.uva.sea.ql.interpreter;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.values.Value;

public abstract class Control {
	
	public abstract JComponent getControl();
	
	public abstract void addListener(ObservableQuestion observableQuestion);
	
	public abstract void addListener(ObservableComputed observableComputed);

	public abstract void setValue(Value value);
	
	public abstract Value getValue();
	
}
