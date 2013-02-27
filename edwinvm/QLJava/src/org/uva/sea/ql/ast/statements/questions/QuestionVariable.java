package org.uva.sea.ql.ast.statements.questions;

import org.uva.sea.ql.ast.expressions.Identifier;

public class QuestionVariable {
	private final Identifier _variable;

	public QuestionVariable(Identifier variable) {
		_variable = variable;
	}
	
	public Identifier getVariable() {
		return _variable;
	}
}