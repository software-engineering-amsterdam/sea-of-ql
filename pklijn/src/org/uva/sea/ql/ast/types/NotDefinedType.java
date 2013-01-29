package org.uva.sea.ql.ast.types;

import java.awt.Component;
import java.awt.Label;

public class NotDefinedType extends Type {

	@Override
	public String toString() {
		return "<NOT DEFINED>";
	}

	@Override
	public Component getAnswerField(boolean enabled) {
		return new Label("<UNDEFINED VALUE>");
	}

}
