package org.uva.sea.ql.gui.render;

import java.awt.Component;

public class Widget {

	private final Component _widget;
	
	public Widget(Component widget) {
		_widget = widget;
	}
	
	public void setToNotEditable() {
		_widget.setEnabled(false);
	}
	
	public Component getWidget() {
		return _widget;
	}
}