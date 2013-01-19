package org.uva.sea.ql.ast.expression.value;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.INodeVisitor;
import org.uva.sea.ql.visitor.typecheck.TypeChecker;

/**
 * Represents a boolean literal expression.
 */
public class Bool extends Value {
	/**
	 * Holds the value of the boolean literal.
	 */
	private final boolean value;

	/**
	 * Constructs a new boolean expression.
	 *
	 * @param value The value.
	 */
	public Bool( boolean value ) {
		this.value = value;
	}

	/**
	 * Retrieves the value of the expression.
	 *
	 * @return The value.
	 */
	public boolean getValue() {
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
		return new org.uva.sea.ql.ast.type.Bool();
	}
}
