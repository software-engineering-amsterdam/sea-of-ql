package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.ast.StatementChecker;
import org.uva.sea.ql.ast.expr.Ident;

public class Form extends Statement {
	
	private Ident id;
	private Body body;

	public Form (Ident id, Body body) {
		this.id=id;
		this.body=body;	
	}
	
	public Ident getID() {
		return id;
	}
	
	public Body getBody() {
		return body;
	}

	@Override
	public boolean accept(StatementChecker visitor) {
		return visitor.visit(this);
	}
	
	
	
}
