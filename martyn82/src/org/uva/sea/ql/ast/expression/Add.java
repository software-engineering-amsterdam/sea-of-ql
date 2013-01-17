package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents an addition expression.
 */
public class Add extends ArithmeticExpression {
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
	
	@Override
	public boolean checkType() {
		// both be Number
		// both be Ident
		// one be Number, other be Ident
		return false;
	}

	@Override
	public Type getType() {
		// both or one money: money
		return null;
	}
}
