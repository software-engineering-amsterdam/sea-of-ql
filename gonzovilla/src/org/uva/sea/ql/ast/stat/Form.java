package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.Ident;

public class Form implements ASTNode {

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

}