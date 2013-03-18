package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactoryFactory;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInteger() || t.isCompatibleToMoney();
	}

	@Override
	public boolean isCompatibleToInteger() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}
	
	@Override
	public WidgetFactory getWidgetFactory(WidgetFactoryFactory widgetFactoryFactory) {
		return null;
	}

}