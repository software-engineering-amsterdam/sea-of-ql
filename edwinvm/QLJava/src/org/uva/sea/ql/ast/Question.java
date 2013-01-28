package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.Str;

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