package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.visitors.StatementVisitor;

public class Form implements ASTNode{
	
	private final Ident id;
	private final Body body;

	public Form(Ident id, Body b) {
		this.id = id;
		this.body = b;
	}
	
	public Ident getId() {
		return id;
	}
	
	public Body getBody() {
		return body;
	}

	
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);		
	}

}
