package org.uva.sea.ql.ast.expressions.binaryExpressions;

import org.uva.sea.ql.ast.expressions.AExpr;

public abstract class ABinaryExpr extends AExpr {
	private final AExpr lhs;
	private final AExpr rhs;

	public ABinaryExpr(AExpr lhs, AExpr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;		
	}
	
	public AExpr getLhs() {
		return lhs;
	}
	
	public AExpr getRhs() {
		return rhs;
	}
}