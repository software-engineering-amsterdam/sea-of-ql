package org.uva.sea.ql.ast.expression.value;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.INodeVisitor;
import org.uva.sea.ql.visitor.typecheck.TypeChecker;

/**
 * Represents a decimal number.
 */
public class Money extends Number {
	/**
	 * Holds the value of this instance.
	 */
	private final double value;

	/**
	 * Constructs a new Money value.
	 *
	 * @param value The value of the literal.
	 */
	public Money( double value ) {
		this.value = value;
	}

	/**
	 * Retrieves the value of this object.
	 *
	 * @return The value.
	 */
	public double getValue() {
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
		return new org.uva.sea.ql.ast.type.Money();
	}
}
