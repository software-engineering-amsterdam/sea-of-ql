package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.visitor.Visitor;

public class UnaryExpr extends Expr {

	private final Expr arg;

	protected UnaryExpr(Expr arg) {
		this.arg = arg;
	}

	public Expr getArg() {
		return arg;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
