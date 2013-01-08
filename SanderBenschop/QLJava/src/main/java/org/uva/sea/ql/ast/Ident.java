package org.uva.sea.ql.ast;

public class Ident extends Expr<String> {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	@Override
	public String getValue() {
		throw new UnsupportedOperationException("Identifiers only have a name, not a value. Use ident.getName() instead.");
	}
	
	public String getName() {
		return name;
	}

}
