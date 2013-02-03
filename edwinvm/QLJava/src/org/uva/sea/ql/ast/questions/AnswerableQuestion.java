package org.uva.sea.ql.ast.questions;

import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Str;

public class AnswerableQuestion extends Question {
	private final Type _type;

	public AnswerableQuestion(Str label, Ident variable, Type type) {
		super(label, variable);
		_type = type;
	}
	
	public Type getType() {
		return _type;
	}
}