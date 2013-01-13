package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a less-than-equals expression.
 */
public class LEq extends BinaryExpression {
	/**
	 * Constructs a new lesser-than-equals expression.
	 * 
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public LEq( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
