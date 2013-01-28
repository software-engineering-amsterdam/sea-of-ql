package org.uva.sea.ql.eval.value;

/**
 * Represents a Money value.
 */
public class Money extends Number {
	private final java.lang.Double value;

	public Money( java.lang.Double value ) {
		super( value );
		this.value = value;
	}

	@Override
	public java.lang.Double getValue() {
		return this.value;
	}

	@Override
	public Value add( Value value ) {
		return value.add( this );
	}

	@Override
	public Value add( Integer value ) {
		return new Money( value.getValue() + this.value );
	}

	@Override
	public Value add( Money value ) {
		return new Money( value.getValue() + this.value );
	}

	@Override
	public Value sub( Value value ) {
		return value.sub( this );
	}

	@Override
	public Value sub( Integer value ) {
		return new Money( value.getValue() - this.value );
	}

	@Override
	public Value sub( Money value ) {
		return new Money( value.getValue() - this.value );
	}

	@Override
	public Value div( Value value ) {
		return value.div( this );
	}

	@Override
	public Value div( Integer value ) {
		return new Money( value.getValue() / this.value );
	}

	@Override
	public Value div( Money value ) {
		return new Money( value.getValue() / this.value );
	}

	@Override
	public Value mul( Value value ) {
		return value.mul( this );
	}

	@Override
	public Value mul( Integer value ) {
		return new Money( value.getValue() * this.value );
	}

	@Override
	public Value mul( Money value ) {
		return new Money( value.getValue() * this.value );
	}

	@Override
	public Value geq( Value value ) {
		return value.geq( this );
	}

	@Override
	public Value geq( Integer value ) {
		return new Boolean( value.getValue() >= this.value );
	}

	@Override
	public Value geq( Money value ) {
		return new Boolean( value.getValue() >= this.value );
	}

	@Override
	public Value gt( Value value ) {
		return value.gt( this );
	}

	@Override
	public Value gt( Integer value ) {
		return new Boolean( value.getValue() > this.value );
	}

	@Override
	public Value gt( Money value ) {
		return new Boolean( value.getValue() > this.value );
	}

	@Override
	public Value leq( Value value ) {
		return value.leq( this );
	}

	@Override
	public Value leq( Integer value ) {
		return new Boolean( value.getValue() <= this.value );
	}

	@Override
	public Value leq( Money value ) {
		return new Boolean( value.getValue() <= this.value );
	}

	@Override
	public Value lt( Value value ) {
		return value.lt( this );
	}

	@Override
	public Value lt( Integer value ) {
		return new Boolean( value.getValue() < this.value );
	}

	@Override
	public Value lt( Money value ) {
		return new Boolean( value.getValue() < this.value );
	}

	@Override
	public Value neg() {
		return new Money( -this.value );
	}

	@Override
	public Value pos() {
		return new Money( +this.value );
	}
}
