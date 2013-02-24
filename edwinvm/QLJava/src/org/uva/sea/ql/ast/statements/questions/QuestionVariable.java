package org.uva.sea.ql.ast.statements.questions;

import org.uva.sea.ql.ast.expressions.literal.Ident;

public class QuestionVariable {
	private final Ident _variable;

	public QuestionVariable(Ident variable) {
		_variable = variable;
	}
	
	public Ident getVariable() {
		return _variable;
	}
}