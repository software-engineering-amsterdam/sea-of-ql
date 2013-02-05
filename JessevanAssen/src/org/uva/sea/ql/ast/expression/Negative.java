package org.uva.sea.ql.ast.expression;

public class Negative extends UnaryExpression {

	public Negative(Expression expression) {
		super(expression);
	}	

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ExpressionVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}
