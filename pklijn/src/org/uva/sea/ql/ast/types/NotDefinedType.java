package org.uva.sea.ql.ast.types;

import javax.swing.JComponent;
import javax.swing.JLabel;

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
	public JComponent getAnswerField(boolean enabled) {
		return new JLabel("<UNDEFINED VALUE>");
	}

	@Override
	public boolean hasValue() {
		return false;
	}
	
	@Override
	public Value getAnswerFieldValue(JComponent answerComponent) {
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
