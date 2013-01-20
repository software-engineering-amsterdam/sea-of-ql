package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.answertype.BoolAnswerType;
import org.uva.sea.ql.ast.answertype.IntAnswerType;
import org.uva.sea.ql.ast.answertype.MoneyAnswerType;
import org.uva.sea.ql.ast.answertype.StringAnswerType;

public interface AnswerTypeVisitor {

	public VisitorResult visit(BoolAnswerType bool);

	public VisitorResult visit(IntAnswerType intType);

	public VisitorResult visit(MoneyAnswerType money);

	public VisitorResult visit(StringAnswerType string);

}
