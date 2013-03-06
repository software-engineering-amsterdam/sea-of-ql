package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.expressions.ASTNode;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.Form;
import org.uva.sea.ql.form.questiontypes.AbstractQuestionTypeComponent;

public abstract class Type implements ASTNode {
	
	protected Form form;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return (obj.getClass().equals(this.getClass()));
	}
	
	public int hashCode() {
		return this.getClass().hashCode();
	};
	
	public boolean isDefined() {
		return true;
	}
	
	public void setForm(Form form) {
		this.form = form;
	}
	
	public abstract AbstractQuestionTypeComponent getAnswerField();
	public abstract Value getDefaultValue();
}
