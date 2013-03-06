package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.gui.observe.AnswerableQuestionObservable;

public abstract class Widget {

	public abstract Value getValue();
	
	public abstract void setDefaultValue();
	
	public abstract void setValue(Value value);
	
	public abstract void setEnabled(boolean enabled);
	
	public abstract void addListener(AnswerableQuestionObservable observable);
	
	public abstract Component getWidget();
	
}