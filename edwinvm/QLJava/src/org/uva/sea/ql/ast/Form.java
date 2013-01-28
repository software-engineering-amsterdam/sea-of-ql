package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;

public class Form implements ASTNode {
	private final Ident _name;
	private final FormStatement _body;

	public Form(Ident name, FormStatement body) {
		_name = name;
		_body = body;
	}

	public Ident getName() {
		return _name;
	}
	
	public FormStatement getBody() {
		return _body;
	}
}