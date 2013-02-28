package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;

import org.uva.sea.ql.ast.values.Value;

public abstract class Widget {

	public abstract void setValue(Value value);
	
	public abstract void setEnabled(boolean enabled);
	
	public abstract Component getWidget();
	
}