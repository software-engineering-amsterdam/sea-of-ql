package org.uva.sea.ql.ast.expressions;

public abstract class BinaryExpression extends Expression {
	private final Expression _leftHandSide, _rightHandSide;
	
	protected BinaryExpression(Expression leftHandSide, Expression rightHandSide) {
		_leftHandSide = leftHandSide;
		_rightHandSide = rightHandSide;
	}
	
	public Expression getLeftHandSide() {
		return _leftHandSide;
	}
	
	public Expression getRightHandSide() {
		return _rightHandSide;
	}
}