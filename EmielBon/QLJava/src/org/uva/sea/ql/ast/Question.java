package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

public class Question extends Statement {

	private final Identifier id;
	private final StringLiteral label;
	private final Type type;
	
	public Question(Identifier id, StringLiteral label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}

	public Identifier getId() {
		return id;
	}
	
	public StringLiteral getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}
	
}