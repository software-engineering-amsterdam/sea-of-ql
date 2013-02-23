package org.uva.sea.ql.ast.forms;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.statements.StatementBody;

public class Form implements ASTNode {
	private final Ident _name;
	private final StatementBody _body;

	public Form(Ident name, StatementBody body) {
		_name = name;
		_body = body;
	}

	public Ident getName() {
		return _name;
	}
	
	public StatementBody getBody() {
		return _body;
	}
}