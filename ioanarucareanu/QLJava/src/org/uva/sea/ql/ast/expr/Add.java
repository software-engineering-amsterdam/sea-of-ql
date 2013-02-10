package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.semanticchecker.ExpressionSemanticVisitor;

public class Add extends Binary {

	private static final String EXPR_OPERATOR = "+";

	public Add(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr) ;
	}
	
	@Override
	public Type accept(ExpressionSemanticVisitor visitor) {
		
		return visitor.visit(this);
	}
	
	@Override
	public String getOperator() {
		
		return EXPR_OPERATOR;
	}

}
