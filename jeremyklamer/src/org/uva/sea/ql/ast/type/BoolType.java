package org.uva.sea.ql.ast.type;

import java.awt.Checkbox;

import ui.UIComponent;

public class BoolType extends Type{
	
	public BoolType(){
		
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public UIComponent getAnswerComp() {
		return new UIComponent(new Checkbox(), "wrap");
	}
	
}
