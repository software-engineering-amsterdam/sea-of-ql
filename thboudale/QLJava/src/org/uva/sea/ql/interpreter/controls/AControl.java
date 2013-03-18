package org.uva.sea.ql.interpreter.controls;

import javax.swing.JComponent;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.interpreter.ObservableQuestion;

public abstract class AControl {

	public abstract void addListener(ObservableQuestion obs);
	public abstract JComponent getControl();
	public abstract AValue getValue();
	public abstract void setValue(AValue value);
}