package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;

import org.uva.sea.ql.ast.values.Value;

public abstract class Widget {

	private final Component _widget;
	
	public Widget(Component widget) {
		_widget = widget;
	}
	
	public abstract void setValue(Value value);
	
	public void setToNotEditable() {
		_widget.setEnabled(false);
	}
	
	public Component getWidget() {
		return _widget;
	}
	
}