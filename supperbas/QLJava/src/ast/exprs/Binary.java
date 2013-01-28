package ast.exprs;

import ast.Expr;


public abstract class Binary extends Expr {
	
	private final Expr lhs;
	private final Expr rhs;

	public Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expr getRhs() {
		return rhs;
	}

	public Expr getLhs() {
		return lhs;
	}

}
