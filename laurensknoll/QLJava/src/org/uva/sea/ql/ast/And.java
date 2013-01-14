package org.uva.sea.ql.ast;

public class And extends Binary {
	
	public And(Expr lhsExpr, Expr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}
}
