package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.types.Type;

public abstract class SingleLineElement extends BodyElement {
	private final Ident id;
	private final StringLit label;
	private final Type type;

	public SingleLineElement(Ident id, StringLit label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}

	public Ident getId() {
		return id;
	}

	public StringLit getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

}
