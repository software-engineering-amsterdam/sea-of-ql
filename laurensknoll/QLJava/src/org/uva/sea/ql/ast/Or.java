package org.uva.sea.ql.ast;

public class Or extends Binary {
	
	public Or(Expr lhsExpr, Expr rhsExpr) {
		super(lhsExpr, rhsExpr);
	}
}
