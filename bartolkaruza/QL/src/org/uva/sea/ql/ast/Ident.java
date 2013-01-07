package org.uva.sea.ql.ast;

public class Ident extends Expr {

	private final String name;
	
	public Ident(Ident ident) {
		this.name = ident.getName();
	}

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
