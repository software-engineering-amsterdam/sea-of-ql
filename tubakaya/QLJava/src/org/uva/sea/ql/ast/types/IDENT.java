package org.uva.sea.ql.ast.types;

public class IDENT extends Expr {

	private final String name;

	public IDENT(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
