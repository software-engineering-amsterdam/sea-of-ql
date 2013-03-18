package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactoryFactory;

public class AnyType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return true;
	}

	@Override
	public boolean isCompatibleToInteger() {
		return true;
	}

	@Override
	public boolean isCompatibleText() {
		return true;
	}

	@Override
	public boolean isCompatibleToBoolean() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public WidgetFactory getWidgetFactory(WidgetFactoryFactory widgetFactoryFactory) {
		throw new UnsupportedOperationException();
	}

}
