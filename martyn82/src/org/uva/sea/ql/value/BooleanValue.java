package org.uva.sea.ql.value;

import org.uva.sea.ql.ast.type.BooleanType;

public class BooleanValue extends Value {
	private final Boolean value;

	public BooleanValue( Boolean value ) {
		this.value = value;
	}

	@Override
	public BooleanType getType() {
		return BooleanType.BOOLEAN;
	}

	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return Boolean.toString( this.value );
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
