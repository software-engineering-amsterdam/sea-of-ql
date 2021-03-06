package org.uva.sea.ql.ast.expr.rel;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;

public class NEq extends Binary {

	private static final String EXPR_OPERATOR = "!=";

	public NEq(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}
	
	@Override
	public String getOperator() {
		return EXPR_OPERATOR;
	}
}
