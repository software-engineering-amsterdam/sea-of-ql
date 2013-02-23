package org.uva.sea.ql.ast.statements.questions;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public class ComputedQuestion extends Question {
	private final Expression _expression;

	public ComputedQuestion(QuestionLabel label, QuestionVariable variable, Expression expression) {
		super(label, variable);
		_expression = expression;
	}
	
	public Expression getExpression() {
		return _expression;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}