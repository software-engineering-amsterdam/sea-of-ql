package org.uva.sea.ql.ast;

public class Bool extends Expr {
	private final String _name;

	public Bool(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
}