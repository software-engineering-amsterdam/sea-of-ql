package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents an addition expression.
 */
public class Add extends BinaryExpression {
	/**
	 * Constructs a new addition expression.
	 * 
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Add( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
