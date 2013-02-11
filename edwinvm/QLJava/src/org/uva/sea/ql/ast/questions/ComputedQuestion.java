package org.uva.sea.ql.ast.questions;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Str;
import org.uva.sea.ql.ast.statements.Question;

public class ComputedQuestion extends Question {
	private final Expr _expression;

	public ComputedQuestion(Str label, Ident variable, Expr expression) {
		super(label, variable);
		_expression = expression;
	}
	
	public Expr getExpression() {
		return _expression;
	}
}