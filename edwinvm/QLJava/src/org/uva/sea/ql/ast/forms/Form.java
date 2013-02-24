package org.uva.sea.ql.ast.forms;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expressions.literal.Identifier;
import org.uva.sea.ql.ast.statements.StatementBody;

public class Form implements ASTNode {
	private final Identifier _name;
	private final StatementBody _body;

	public Form(Identifier name, StatementBody body) {
		_name = name;
		_body = body;
	}

	public Identifier getName() {
		return _name;
	}
	
	public StatementBody getBody() {
		return _body;
	}
}