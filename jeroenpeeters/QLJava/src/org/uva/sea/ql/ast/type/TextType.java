package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactoryFactory;

public class TextType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleText();
	}

	@Override
	public boolean isCompatibleText() {
		return true;
	}
	
	@Override
	public WidgetFactory getWidgetFactory(WidgetFactoryFactory widgetFactoryFactory) {
		return widgetFactoryFactory.newTextWidgetFactory();
	}

}