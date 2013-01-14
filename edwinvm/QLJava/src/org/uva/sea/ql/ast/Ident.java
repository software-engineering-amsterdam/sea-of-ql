package org.uva.sea.ql.ast;

public class Ident extends Expr {
	private final String _name;

	public Ident(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
}