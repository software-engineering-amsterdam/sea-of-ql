package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.answertype.BoolAnswerType;
import org.uva.sea.ql.ast.answertype.IntAnswerType;
import org.uva.sea.ql.ast.answertype.MoneyAnswerType;
import org.uva.sea.ql.ast.answertype.StringAnswerType;
import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public class PrintAnswerTypeVisitor implements AnswerTypeVisitor<Boolean> {

	@Override
	public Boolean visit(BoolAnswerType bool) {
		System.out.println("Visiting Bool AnswerType");

		return true;
	}

	@Override
	public Boolean visit(IntAnswerType intType) {
		System.out.println("Visiting Int AnswerType");

		return true;
	}

	@Override
	public Boolean visit(MoneyAnswerType money) {
		System.out.println("Visiting Money AnswerType");

		return true;
	}

	@Override
	public Boolean visit(StringAnswerType string) {
		System.out.println("Visiting String AnswerType");

		return true;
	}

}
