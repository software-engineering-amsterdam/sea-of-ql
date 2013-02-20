package org.uva.sea.ql.rendering.controls;

import javax.swing.JComponent;

import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.rendering.ObservableQuestion;

public abstract class Control {

	public abstract Value getValue();
	public abstract JComponent getControl();
	public abstract void setValue(Value value);
	public abstract void addListener(ObservableQuestion observableQuestion);

}
