package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.answertype.BoolAnswerType;
import org.uva.sea.ql.ast.answertype.IntAnswerType;
import org.uva.sea.ql.ast.answertype.MoneyAnswerType;
import org.uva.sea.ql.ast.answertype.StringAnswerType;
import org.uva.sea.ql.visitor.AnswerTypeVisitor;
import org.uva.sea.ql.visitor.VisitorResult;

public class PrintAnswerTypeVisitor implements AnswerTypeVisitor {

	@Override
	public VisitorResult visit(BoolAnswerType bool) {
		System.out.println("Visiting Bool AnswerType");

		return null;
	}

	@Override
	public VisitorResult visit(IntAnswerType intType) {
		System.out.println("Visiting Int AnswerType");

		return null;
	}

	@Override
	public VisitorResult visit(MoneyAnswerType money) {
		System.out.println("Visiting Money AnswerType");

		return null;
	}

	@Override
	public VisitorResult visit(StringAnswerType string) {
		System.out.println("Visiting String AnswerType");

		return null;
	}

}
