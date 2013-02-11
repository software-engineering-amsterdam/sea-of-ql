package org.uva.sea.ql.ast.expr;


public class And extends Binary {

	private static final String EXPR_OPERATOR = "&&";

	public And(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}

	@Override
	public String getOperator() {
		
		return EXPR_OPERATOR;
	}

}
