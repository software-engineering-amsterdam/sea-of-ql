package org.uva.sea.ql.ast.expr.grouping;


public abstract class UnaryExpr extends Expr {

	private Expr rhs;
	
	protected UnaryExpr(int lineNumber, Expr rhs) {
		super(lineNumber);
		this.rhs = rhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}

}
