package org.uva.sea.ql.ast.answertype;

import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public class IntAnswerType extends AbstractAnswerType {

	public String getType() {
		return "Integer";
	}

	@Override
	public void accept(AnswerTypeVisitor visitor) {
		visitor.visit(this);
	}

}
