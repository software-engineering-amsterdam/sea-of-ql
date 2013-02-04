package org.uva.sea.ql.ast.expr;

public class Add extends BinaryExpr {

	public Add(Expr leftExpression, Expr rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ExprVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
