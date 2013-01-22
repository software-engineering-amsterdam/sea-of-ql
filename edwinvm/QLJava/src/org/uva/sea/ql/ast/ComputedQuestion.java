package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Str;

public class ComputedQuestion extends FormStatement {
	private final Str _label;
	private final Ident _variable;
	private final Expr _expression;

	public ComputedQuestion(Str label, Ident variable, Expr expression) {
		_label = label;
		_variable = variable;
		_expression = expression;
	}
	
	public Str getLabel() {
		return _label;
	}
	
	public Ident getVariable() {
		return _variable;
	}
	
	public Expr getExpression() {
		return _expression;
	}
}