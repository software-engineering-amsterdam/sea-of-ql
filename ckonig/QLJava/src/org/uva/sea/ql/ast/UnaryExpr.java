package org.uva.sea.ql.ast;

public class UnaryExpr extends Expr {
	private Expr adjacent;

	public UnaryExpr(Expr ex) {
		this.adjacent = ex;
	}

	public Expr getAdjacent() {
		return this.adjacent;
	}
}
