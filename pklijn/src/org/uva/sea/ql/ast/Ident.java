package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.values.Value;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return null;
	}

}
