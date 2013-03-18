package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactoryFactory;

public class BooleanType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBoolean();
	}

	@Override
	public boolean isCompatibleToBoolean() {
		return true;
	}

	@Override
	public WidgetFactory getWidgetFactory(WidgetFactoryFactory widgetFactoryFactory) {
		return widgetFactoryFactory.newBooleanWidgetFactory();
	}
	
}
