package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.answertype.BoolAnswerType;
import org.uva.sea.ql.ast.answertype.IntAnswerType;
import org.uva.sea.ql.ast.answertype.MoneyAnswerType;
import org.uva.sea.ql.ast.answertype.StringAnswerType;

public interface AnswerTypeVisitor<T> {

	public T visit(BoolAnswerType bool);

	public T visit(IntAnswerType intType);

	public T visit(MoneyAnswerType money);

	public T visit(StringAnswerType string);

}
