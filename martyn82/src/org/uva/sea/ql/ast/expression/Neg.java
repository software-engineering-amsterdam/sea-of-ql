package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a negative expression.
 */
public class Neg extends UnaryNumericExpression {
	/**
	 * Constructs a new negative expression.
	 * 
	 * @param expression
	 */
	public Neg( Expression expression ) {
		super( expression );
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
