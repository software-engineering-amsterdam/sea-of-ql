package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactoryFactory;

public class MoneyType extends NumericType {

	@Override
	public WidgetFactory getWidgetFactory(WidgetFactoryFactory widgetFactoryFactory) {
		return widgetFactoryFactory.newMoneyWidgetFactory();
	}
	
}
