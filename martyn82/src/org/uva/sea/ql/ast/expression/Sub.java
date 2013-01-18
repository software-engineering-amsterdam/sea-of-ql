package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.type.Type;

/**
 * Represents a subtraction expression.
 */
public class Sub extends ArithmeticExpression {
	/**
	 * Constructs a new subtraction expression.
	 * 
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Sub( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
