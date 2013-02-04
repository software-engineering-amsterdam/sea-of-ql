package org.uva.sea.ql.ast.type;

import ui.UIComponent;

public class UndefinedType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	//This type is used to catch UndefinedTypes and will never be called to provides a component. 
	@Override
	public UIComponent getAnswerComp() {
		return null;
	}

}
