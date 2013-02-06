package org.uva.sea.ql.evaluator.value;

import org.uva.sea.ql.ast.type.Int;

/**
 * Represents an Integer value.
 */
public class Integer extends Number {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.Integer value;

	/**
	 * Constructs a new Integer value.
	 *
	 * @param value
	 */
	public Integer( java.lang.Integer value ) {
		super( value );
		this.value = value;
	}

	@Override
	public Int getType() {
		return new Int();
	}

	@Override
	public java.lang.Integer getValue() {
		return this.value;
	}

	@Override
	public Value add( Value value ) {
		return value.add( this );
	}

	@Override
	protected Value add( Integer value ) {
		return new Integer( value.getValue() + this.value );
	}

	@Override
	protected Value add( Money value ) {
		return new Money( value.getValue() + this.value );
	}

	@Override
	public Value sub( Value value ) {
		return value.sub( this );
	}

	@Override
	protected Value sub( Integer value ) {
		return new Integer( value.getValue() - this.value );
	}

	@Override
	protected Value sub( Money value ) {
		return new Money( value.getValue() - this.value );
	}

	@Override
	public Value div( Value value ) {
		return value.div( this );
	}

	@Override
	protected Value div( Integer value ) {
		return new Integer( value.getValue() / this.value );
	}

	@Override
	protected Value div( Money value ) {
		return new Money( value.getValue() / this.value );
	}

	@Override
	public Value mul( Value value ) {
		return value.mul( this );
	}

	@Override
	protected Value mul( Integer value ) {
		return new Integer( value.getValue() * this.value );
	}

	@Override
	protected Value mul( Money value ) {
		return new Money( value.getValue() * this.value );
	}

	@Override
	public Value geq( Value value ) {
		return value.geq( this );
	}

	@Override
	protected Value geq( Integer value ) {
		return new Boolean( value.getValue() >= this.value );
	}

	@Override
	protected Value geq( Money value ) {
		return new Boolean( value.getValue() >= this.value );
	}

	@Override
	public Value gt( Value value ) {
		return value.gt( this );
	}

	@Override
	protected Value gt( Integer value ) {
		return new Boolean( value.getValue() > this.value );
	}

	@Override
	protected Value gt( Money value ) {
		return new Boolean( value.getValue() > this.value );
	}

	@Override
	public Value leq( Value value ) {
		return value.leq( this );
	}

	@Override
	protected Value leq( Integer value ) {
		return new Boolean( value.getValue() <= this.value );
	}

	@Override
	protected Value leq( Money value ) {
		return new Boolean( value.getValue() <= this.value );
	}

	@Override
	public Value lt( Value value ) {
		return value.lt( this );
	}

	@Override
	protected Value lt( Integer value ) {
		return new Boolean( value.getValue() < this.value );
	}

	@Override
	protected Value lt( Money value ) {
		return new Boolean( value.getValue() < this.value );
	}

	@Override
	public Value neg() {
		return new Integer( -this.value );
	}

	@Override
	public Value pos() {
		return new Integer( +this.value );
	}
}
