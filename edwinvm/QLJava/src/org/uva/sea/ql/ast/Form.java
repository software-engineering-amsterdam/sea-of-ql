package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.statements.FormStatement;

public class Form implements ASTNode {
	private final Ident _name;
	private final List<FormStatement> _body;

	public Form(Ident name, ArrayList<FormStatement> body) {
		_name = name;
		_body = body;
	}

	public Ident getName() {
		return _name;
	}
	
	public List<FormStatement> getBody() {
		return _body;
	}
}