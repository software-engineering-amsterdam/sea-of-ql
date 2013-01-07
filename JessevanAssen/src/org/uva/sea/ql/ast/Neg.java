package org.uva.sea.ql.ast;

public class Neg extends Expr {

	private final Expr expression;
	
	public Neg(Expr expression) {
		this.expression = expression;
	}

}
