package org.uva.sea.ql.visitor.ui.widgets;


public interface WidgetFactory {

	Widget createWidget(final String caption, final WidgetObserver widgetObserver);
	
}
