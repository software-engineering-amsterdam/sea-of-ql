package org.uva.sea.ql.ast.expr;

public class GT extends BinaryExpr {

	public GT(Expr leftExpression, Expr rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ExprVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
