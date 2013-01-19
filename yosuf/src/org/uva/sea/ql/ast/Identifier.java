package org.uva.sea.ql.ast;

public class Identifier extends Expression {

	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
