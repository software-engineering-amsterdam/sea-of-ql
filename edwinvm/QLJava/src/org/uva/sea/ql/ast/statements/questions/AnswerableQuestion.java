package org.uva.sea.ql.ast.statements.questions;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public class AnswerableQuestion extends Question {
	private final Type _type;

	public AnswerableQuestion(QuestionLabel label, QuestionVariable variable, Type type) {
		super(label, variable);
		_type = type;
	}
	
	public Type getType() {
		return _type;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}