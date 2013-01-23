package org.uva.sea.ql.ast.questions;

import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Str;

public class AnswerableQuestion extends Question {
	private final Type _type;

	public AnswerableQuestion(Str label, Ident variable, Type type) {
		setLabel(label);
		setVariable(variable);
		_type = type;
	}
	
	public Type getType() {
		return _type;
	}
}