package org.uva.sea.ql.ast.expression.value;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.INodeVisitor;
import org.uva.sea.ql.visitor.typecheck.TypeChecker;

/**
 * Represents an integer expression.
 */
public class Int extends Number {
	/**
	 * Holds the integer value of the expression.
	 */
	private final int value;

	/**
	 * Constructs a new integer expression.
	 *
	 * @param value The value of the expression.
	 */
	public Int( int value ) {
		this.value = value;
	}

	/**
	 * Retrieves the value of the expression.
	 *
	 * @return The value.
	 */
	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.valueOf( this.value );
	}

	@Override
	public void accept( INodeVisitor visitor ) {
		visitor.visit( this );
	}

	@Override
	public Type accept( TypeChecker visitor ) {
		visitor.visit( this );
		return new org.uva.sea.ql.ast.type.Int();
	}
}