package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public class String extends AbstractType {

	public java.lang.String getType() {
		return "String";
	}

	@Override
	public void accept(AnswerTypeVisitor<?> visitor) {
		visitor.visit(this);
	}

}
