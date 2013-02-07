package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringValue;


public class Question implements QLItem {
	
	private final Ident id;
	private final StringValue label;
	private final Type type;
	
	public Question(Ident id, StringValue label, Type type) {
		super();
		this.id = id;
		this.label = label;
		this.type = type;
	}

	public Ident getId() {
		return id;
	}

	public StringValue getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

}
