package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.Bool;

/**
 * Represents a Boolean value.
 */
public class Boolean extends Value {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.Boolean value;

	/**
	 * Constructs a new Boolean value.
	 *
	 * @param value
	 */
	public Boolean( java.lang.Boolean value ) {
		this.value = value;
	}

	@Override
	public Bool getType() {
		return new Bool();
	}

	@Override
	public java.lang.Boolean getValue() {
		return this.value;
	}

	@Override
	public Value and( Value value ) {
		return value.and( this );
	}

	@Override
	protected Value and( Boolean value ) {
		return new Boolean( value.getValue() && this.value );
	}

	@Override
	public Value or( Value value ) {
		return value.or( this );
	}

	@Override
	protected Value or( Boolean value ) {
		return new Boolean( value.getValue() || this.value );
	}

	@Override
	public Value not() {
		return new Boolean( !this.value );
	}
}
