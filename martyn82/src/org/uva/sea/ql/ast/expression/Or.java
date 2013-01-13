package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a logical OR expression.
 */
public class Or extends BinaryExpression {
	/**
	 * Constructs a new logical OR expression.
	 * 
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Or( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
