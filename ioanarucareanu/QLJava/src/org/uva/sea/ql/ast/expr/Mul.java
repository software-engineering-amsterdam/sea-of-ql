package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.semanticchecker.ReturnType;

public class Mul extends Binary {

	private static final String EXPR_OPERATOR = "*";
	
	public Mul(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr) ;
	}
	
	@Override
	public ReturnType accept(ExpressionVisitor visitor) {
		
		return visitor.visit(this);
	}
	
	@Override
	public String getOperator() {
		
		return EXPR_OPERATOR;
	}

}
