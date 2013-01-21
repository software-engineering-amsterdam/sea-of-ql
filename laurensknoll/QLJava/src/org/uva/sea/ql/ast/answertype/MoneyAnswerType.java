package org.uva.sea.ql.ast.answertype;

import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public class MoneyAnswerType extends AbstractAnswerType {

	public String getType() {
		return "Money";
	}

	@Override
	public void accept(AnswerTypeVisitor visitor) {
		visitor.visit(this);
	}

}
