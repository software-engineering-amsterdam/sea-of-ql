package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;

public abstract class Question extends Statement {
	private final Ident id;
	private final String label;
	private final Type type;
	
	public Question(Ident id, String label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}
	
	public Ident getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}
}
