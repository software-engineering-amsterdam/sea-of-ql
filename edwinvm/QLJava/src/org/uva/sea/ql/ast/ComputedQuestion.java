package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Str;

public class ComputedQuestion extends Question {
	private final Expr _expression;

	public ComputedQuestion(Str label, Ident variable, Expr expression) {
		setLabel(label);
		setVariable(variable);
		_expression = expression;
	}
	
	public Expr getExpression() {
		return _expression;
	}
}