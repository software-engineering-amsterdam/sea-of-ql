package org.uva.sea.ql.ast.expression;


public class Identifier implements Expression {
	
	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
