package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.Expr;

public class Type {

	private boolean computated = false;
	private Expr expr;
	
	public void add(Expr expr) {
		this.computated = true;
		this.expr = expr;
		
	}

	public boolean isComputated() {
		return computated;
	}

	public void setComputated(boolean computated) {
		this.computated = computated;
	}

	public Expr getExpr() {
		return expr;
	}
}
