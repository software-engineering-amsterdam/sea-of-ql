package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a greater-than expression.
 */
public class GT extends BinaryExpression {
	/**
	 * Constructs a new greater-than expression.
	 * 
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public GT( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
