package org.uva.sea.ql.visitor.ui.widgets;

import org.uva.sea.ql.ast.DataType;

public class WidgetFactory {

	public static Widget createWidget(final DataType dt, final String caption, final WidgetObserver widgetObserver){
		switch(dt){
		case BOOLEAN: 
			return new CheckboxWidget(caption, widgetObserver);
		case INTEGER:
			return new NumberWidget(caption, widgetObserver);
		case MONEY:
			return new CurrencyWidget(caption, widgetObserver);
		case TEXT:
			return new TextWidget(caption, widgetObserver);
		default:
			throw new IllegalStateException("Unsupported DataType: " + dt);
		}
	}
	
}