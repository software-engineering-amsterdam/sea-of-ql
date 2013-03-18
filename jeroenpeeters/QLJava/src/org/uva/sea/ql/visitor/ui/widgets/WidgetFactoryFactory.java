package org.uva.sea.ql.visitor.ui.widgets;

public interface WidgetFactoryFactory {

	WidgetFactory newBooleanWidgetFactory();
	
	WidgetFactory newIntegerWidgetFactory();
	
	WidgetFactory newMoneyWidgetFactory();
	
	WidgetFactory newTextWidgetFactory();
	
}