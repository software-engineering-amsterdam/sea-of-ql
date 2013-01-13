package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a logical AND expression.
 */
public class And extends BinaryExpression {
	/**
	 * Constructs a new logical AND expression.
	 * 
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public And( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
