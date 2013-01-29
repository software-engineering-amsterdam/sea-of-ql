package org.uva.sea.ql.ast.type;

import java.awt.TextField;

import ui.UIComponent;

public class Numeric extends Type {
	
	private final int UI_COMPONENT_WIDTH = 100;
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}
	
	@Override
	public boolean isCompatibleToInt() { 
		return true; 
	}
	
	@Override
	public boolean isCompatibleToMoney() { 
		return true; 
	}
	
	@Override
	public boolean isCompatibleToNumeric() { 
		return true; 
	}

	@Override
	public UIComponent getAnswerComp() {
		TextField answerField = new TextField();
		return new UIComponent(answerField, "wrap, width :"+ UI_COMPONENT_WIDTH + ":");
	}

}
