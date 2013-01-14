package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Value;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Value interpret() {
		// TODO Auto-generated method stub
		return null;
	}

}
