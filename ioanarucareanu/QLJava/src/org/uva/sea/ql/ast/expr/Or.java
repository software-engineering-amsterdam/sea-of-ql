package org.uva.sea.ql.ast.expr;

public class Or extends Binary {

	private static final String EXPR_OPERATOR = "||";

	public Or(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}

	@Override
	public String getOperator() {
		
		return EXPR_OPERATOR;
	}

}
