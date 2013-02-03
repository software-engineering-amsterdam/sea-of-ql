package org.uva.sea.ql.ast.types;

import java.awt.Component;

import org.uva.sea.ql.ast.expressions.ASTNode;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.Form;

public abstract class Type implements ASTNode {
	
	protected Form form;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return (obj.getClass().equals(this.getClass()));
	}
	
	public boolean isDefined() {
		return true;
	}
	
	public void setForm(Form form) {
		this.form = form;
	}
	
	public abstract Component getAnswerField(boolean enabled);
	public abstract boolean hasValue();
	public abstract Value getAnswerFieldValue(Component answerComponent);
	public abstract void setAnswerFieldValue(Value value);
	public abstract Value getDefaultValue();
}
