package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.statements.questions.QuestionLabel;

public abstract class Question extends FormStatement {
	private final QuestionLabel _label;
	private final Ident _variable;
	
	protected Question(QuestionLabel label, Ident variable) {
		_label = label;
		_variable = variable;
	}
	
	public QuestionLabel getLabel() {
		return _label;
	}
	
	public Ident getVariable() {
		return _variable;
	}
}