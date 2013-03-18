package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactoryFactory;

public class UndefType extends Type{

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public WidgetFactory getWidgetFactory(WidgetFactoryFactory widgetFactoryFactory) {
		return null;
	}
	
}
