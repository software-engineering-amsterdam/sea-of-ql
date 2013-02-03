package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.StringLiteral;

public class Question extends Node {

	private final Identifier id;
	private final StringLiteral label;
	
	public Question(Identifier id, StringLiteral label) {
		this.id = id;
		this.label = label;
	}

	public Identifier getId() {
		return id;
	}
	
	public StringLiteral getLabel() {
		return label;
	}
	
}