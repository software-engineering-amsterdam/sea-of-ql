package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.BooleanType;

/**
 * Represents a Boolean value.
 */
public class BooleanValue extends Value {
	/**
	 * Holds the inner value.
	 */
	private final Boolean value;

	/**
	 * Constructs a new Boolean value.
	 *
	 * @param value
	 */
	public BooleanValue( Boolean value ) {
		this.value = value;
	}

	@Override
	public BooleanType getType() {
		return new BooleanType();
	}

	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public Value and( Value value ) {
		return value.and( this );
	}

	@Override
	protected Value and( BooleanValue value ) {
		return new BooleanValue( value.getValue() && this.value );
	}

	@Override
	public Value or( Value value ) {
		return value.or( this );
	}

	@Override
	protected Value or( BooleanValue value ) {
		return new BooleanValue( value.getValue() || this.value );
	}

	@Override
	public Value not() {
		return new BooleanValue( !this.value );
	}
}
