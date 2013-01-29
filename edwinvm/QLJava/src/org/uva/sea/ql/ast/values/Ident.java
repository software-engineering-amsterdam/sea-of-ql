package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.Expr;

public class Ident extends Expr {
	private final String _name;

	public Ident(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
}