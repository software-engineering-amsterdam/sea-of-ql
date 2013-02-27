package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.visitor.VisitorStatements;

public class Form extends FormUnit {

	private final Ident name;
	private final Block body;

	public Form(Ident name, Block body) {
		this.name = name;
		this.body = body;
	}

	public Ident getName() {
		return name;
	}

	public Block getBody() {
		return body;
	}

	@Override
	public <T> T accept(VisitorStatements<T> visitor) {
		return visitor.visit(this);
	}
	
}