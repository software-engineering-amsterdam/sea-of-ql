package org.uva.sea.ql.ast.expr;

public abstract class BinaryExpr extends Expr {
	private final Expr lhs, rhs;

	protected BinaryExpr(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expr getLhs() {
		return lhs;
	}

	public Expr getRhs() {
		return rhs;
	}
	
	@Override
	public String toString() {
		return "Binary: " +this.getClass().toString()+ "  LHS:("+lhs.toString() + ")  RHS("+rhs.toString()+")"; 
	}
}
