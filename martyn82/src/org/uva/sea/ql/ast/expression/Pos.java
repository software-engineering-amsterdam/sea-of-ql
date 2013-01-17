package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a positive expression.
 */
public class Pos extends UnaryNumericExpression {
	/**
	 * Constructs a new positive expression.
	 * 
	 * @param expression
	 */
	public Pos( Expression expression ) {
		super( expression );
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
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
