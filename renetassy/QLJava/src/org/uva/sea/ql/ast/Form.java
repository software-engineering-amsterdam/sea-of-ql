package org.uva.sea.ql.ast;

public class Form implements ASTNode {
	
	private Ident id;
	private Body content;

	public Form (Ident id, Body content) {
		
		this.id=id;
		this.content=content;	
	}
}
