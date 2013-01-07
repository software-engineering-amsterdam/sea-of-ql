package org.uva.sea.ql.ast;

public class Not extends Expr {

	private final Expr expression;
	
	public Not(Expr expression) {
		this.expression = expression;
	}

}
