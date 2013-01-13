package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ASTNodeVisitor;

public class Div extends BinaryExpr {

	public Div(Expr leftExpression, Expr rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
