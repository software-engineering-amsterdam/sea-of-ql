package org.uva.sea.ql.ast.types;

import java.awt.Component;
import java.awt.TextField;

public class StringType extends Type {

	@Override
	public String toString() {
		return "String";
	}

	@Override
	public Component getAnswerField(boolean enabled) {
		TextField answerField = new TextField("str");
		answerField.setEnabled(enabled);
		return answerField;
	}
}
