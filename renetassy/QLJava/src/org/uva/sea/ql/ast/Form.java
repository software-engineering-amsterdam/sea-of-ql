package org.uva.sea.ql.ast;

import org.uva.sea.ql.StatementChecker;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stmnt.Body;

public class Form extends QLProgram {
	
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
