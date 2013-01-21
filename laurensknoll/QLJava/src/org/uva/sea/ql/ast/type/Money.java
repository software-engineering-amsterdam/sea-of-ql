package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public class Money extends Numeric {

	public java.lang.String getType() {
		return "Money";
	}

	@Override
	public void accept(AnswerTypeVisitor<?> visitor) {
		visitor.visit(this);
	}

}
