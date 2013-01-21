package org.uva.sea.ql.ast.answertype;

import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public class BoolAnswerType extends AbstractAnswerType {

	public String getType() {
		return "Boolean";
	}

	@Override
	public void accept(AnswerTypeVisitor<?> visitor) {
		visitor.visit(this);
	}

}
