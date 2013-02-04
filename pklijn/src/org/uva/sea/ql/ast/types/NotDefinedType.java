package org.uva.sea.ql.ast.types;

import java.awt.Component;
import java.awt.Label;

import org.uva.sea.ql.ast.values.Value;

public class NotDefinedType extends Type {

	@Override
	public String toString() {
		return "<NOT DEFINED>";
	}

	@Override
	public boolean isDefined() {
		return false;
	};
	
	@Override
	public Component getAnswerField(boolean enabled) {
		return new Label("<UNDEFINED VALUE>");
	}

	@Override
	public boolean hasValue() {
		return false;
	}
	
	@Override
	public Value getAnswerFieldValue(Component answerComponent) {
		return null;
	}
	
	@Override
	public Value getDefaultValue() {
		return null;
	}
	
	@Override
	public void setAnswerFieldValue(Value value) {
		
	}
}
