package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Str;

public abstract class Question extends FormStatement {
	private final Str _label;
	private final Ident _variable;
	
	protected Question(Str label, Ident variable) {
		_label = label;
		_variable = variable;
	}
	
	public Str getLabel() {
		return _label;
	}
	
	public Ident getVariable() {
		return _variable;
	}
}