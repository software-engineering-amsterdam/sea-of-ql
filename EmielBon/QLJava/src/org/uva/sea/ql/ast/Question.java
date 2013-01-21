package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.data.Str;

public class Question extends Expression {

	private final Ident id;
	private final Str label;
	
	public Question(Ident id, Str label) {
		this.id = id;
		this.label = label;
	}

	public Ident getId() {
		return id;
	}
	
	public Str getLabel() {
		return label;
	}
	
}