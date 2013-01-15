package org.uva.sea.ql.ast;

public class Str extends Expr {
	private final String _name;

	public Str(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
}