package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a logical NOT expression.
 */
public class Not extends UnaryExpression {
	/**
	 * Constructs a new logical NOT expression.
	 * 
	 * @param expression
	 */
	public Not( Expression expression ) {
		super( expression );
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
