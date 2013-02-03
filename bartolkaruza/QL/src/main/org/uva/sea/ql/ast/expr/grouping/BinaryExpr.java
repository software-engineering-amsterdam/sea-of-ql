package org.uva.sea.ql.ast.expr.grouping;

public abstract class BinaryExpr extends Expr {
	
	private Expr lhs;
	private Expr rhs;
	
	protected BinaryExpr(int lineNumber, Expr lhs, Expr rhs) {
		super(lineNumber);
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}

}
