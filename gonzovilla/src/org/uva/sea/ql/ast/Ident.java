package org.uva.sea.ql.ast;

public class Ident implements ASTNode {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
