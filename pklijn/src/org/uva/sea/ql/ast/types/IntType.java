package org.uva.sea.ql.ast.types;

import java.awt.Component;
import java.awt.TextField;

public class IntType extends Type {

	@Override
	public String toString() {
		return "Integer";
	}
	
	@Override
	public Component getAnswerField(boolean enabled) {
		TextField answerField = new TextField("int");
		answerField.setEnabled(enabled);
		return answerField;
	}
}
