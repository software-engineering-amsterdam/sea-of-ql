package org.uva.sea.ql.ast.expression;

public class LesserThanOrEqualTo extends BinaryExpression {

	public LesserThanOrEqualTo(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ExpressionVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
