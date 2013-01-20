package org.uva.sea.ql.ast;

public class Unary extends Expr {
	
	private Expr arg;

	public Unary(Expr arg) {
		this.arg = arg;
	}

	public Expr getArg() {
		return arg;
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
