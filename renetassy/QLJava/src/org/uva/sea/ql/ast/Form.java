package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stmnt.Body;

public class Form implements ASTNode {
	
	private Ident id;
	private Body content;

	public Form (Ident id, Body content) {
		
		this.id=id;
		this.content=content;	
	}
}
