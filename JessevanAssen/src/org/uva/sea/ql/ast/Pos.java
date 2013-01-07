package org.uva.sea.ql.ast;

public class Pos extends Expr {

	private final Expr expression;
	
	public Pos(Expr expression) {
		this.expression = expression;
	}

}
