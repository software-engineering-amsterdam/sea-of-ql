package org.uva.sea.ql.ast;


public class Ident extends Expression {

	private final String name;

	public Ident(String name) {
		this.name = name;
		
		System.out.println("Ident: " + name);
	}
	
	public String getName() {
		return name;
	}
}
