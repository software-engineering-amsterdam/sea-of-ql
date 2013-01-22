package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Str;

public class AnswerableQuestion extends FormStatement {
	private final Str _label;
	private final Ident _variable;
	private final Type _type;

	public AnswerableQuestion(Str label, Ident variable, Type type) {
		_label = label;
		_variable = variable;
		_type = type;
	}
	
	public Str getLabel() {
		return _label;
	}
	
	public Ident getVariable() {
		return _variable;
	}
	
	public Type getType() {
		return _type;
	}
}