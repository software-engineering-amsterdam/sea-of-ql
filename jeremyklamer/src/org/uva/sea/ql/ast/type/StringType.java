package org.uva.sea.ql.ast.type;

import java.awt.TextField;

import ui.UIComponent;

public class StringType extends Type{

	private final int UI_COMPONENT_WIDTH = 150;
	
	public StringType(){
		
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();   
		//test
	}
	
	@Override
	public boolean isCompatibleToStr(){
		return true;
	}

	@Override
	public UIComponent getAnswerComp() {
		TextField answerField = new TextField();
		answerField.setSize(UI_COMPONENT_WIDTH, answerField.getHeight());
		return new UIComponent(answerField, "wrap, width :"+ UI_COMPONENT_WIDTH + ":");
	}
}
