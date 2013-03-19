package org.uva.sea.ql.renderer;


import javax.swing.JComponent;

import org.uva.sea.ql.evaluator.values.Value;

public abstract class Control {

	public abstract void setValue(Value val);
	public abstract Value getValue();
	public abstract void setVisible(boolean v);
	public abstract JComponent getControl();
	public abstract void addListener(QuestionObservable qo);

}
