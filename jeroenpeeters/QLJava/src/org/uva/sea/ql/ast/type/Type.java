package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactoryFactory;

public abstract class Type implements ASTNode {
	
	public abstract boolean isCompatibleTo(Type t);
	
	public abstract WidgetFactory getWidgetFactory(WidgetFactoryFactory widgetFactoryFactory);

	public boolean isCompatibleToInteger() {
		return false;
	}

	public boolean isCompatibleText() {
		return false;
	}

	public boolean isCompatibleToBoolean() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}


}