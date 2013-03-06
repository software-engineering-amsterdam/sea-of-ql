package org.uva.sea.ql.visitor.ui.widgets;

import org.uva.sea.ql.ast.DataType;

public class WidgetFactory {

	public static BaseWidget createWidget(final DataType dt, final String caption){
		switch(dt){
		case BOOLEAN: 
			return new CheckboxWidget(caption);
		case INTEGER:
			return new NumberWidget(caption);
		case MONEY:
			return new CurrencyWidget(caption);
		case TEXT:
			return new TextWidget(caption);
		default:
			throw new IllegalStateException("Unsupported DataType: " + dt);
		}
	}
	
}