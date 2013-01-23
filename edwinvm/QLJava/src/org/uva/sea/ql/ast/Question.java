package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Str;

public abstract class Question extends FormStatement {
	private Str _label;
	private Ident _variable;
	
	public Str getLabel() {
		return _label;
	}
	
	public void setLabel(Str label) {
		_label = label;
	}
	
	public Ident getVariable() {
		return _variable;
	}
	
	public void setVariable(Ident variable) {
		_variable = variable;
	}
}