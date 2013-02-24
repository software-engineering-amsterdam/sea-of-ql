package org.uva.sea.ql.renderer.control;

import javax.swing.JComponent;

import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.renderer.ObservableQuestion;

public abstract class Control {
	
	public abstract Value getValue();
	public abstract JComponent getWidget();
	public abstract void addListener(ObservableQuestion obsQuestion);
	public abstract void setValue(Value v);

}
