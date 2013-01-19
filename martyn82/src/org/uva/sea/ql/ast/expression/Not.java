package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.type.Type;

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
