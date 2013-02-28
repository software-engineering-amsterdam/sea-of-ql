package org.uva.sea.ql.gui;

import java.awt.Component;

public class Widget {

	private final Component _widget;
	
	public Widget(Component widget) {
		_widget = widget;
	}
	
	public Component getWidget() {
		return _widget;
	}
}