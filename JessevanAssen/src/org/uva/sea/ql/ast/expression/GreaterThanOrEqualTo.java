package org.uva.sea.ql.ast.expression;

public class GreaterThanOrEqualTo extends BinaryExpression {

	public GreaterThanOrEqualTo(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ExpressionVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
