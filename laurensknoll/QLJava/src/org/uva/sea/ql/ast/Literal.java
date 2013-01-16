package org.uva.sea.ql.ast;

public class Literal extends Expr {

	private final String name;

	public Literal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
