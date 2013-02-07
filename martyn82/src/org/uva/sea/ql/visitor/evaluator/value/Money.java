package org.uva.sea.ql.visitor.evaluator.value;

/**
 * Represents a Money value.
 */
public class Money extends Number {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.Double value;

	/**
	 * Constructs a new Money value.
	 *
	 * @param value
	 */
	public Money( java.lang.Double value ) {
		super( value );
		this.value = value;
	}

	@Override
	public org.uva.sea.ql.ast.type.Money getType() {
		return new org.uva.sea.ql.ast.type.Money();
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
	protected Value add( Integer value ) {
		return new Money( value.getValue() + this.value );
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
		return new Money( value.getValue() - this.value );
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
		return new Money( value.getValue() / this.value );
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
		return new Money( value.getValue() * this.value );
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
		return new Money( -this.value );
	}

	@Override
	public Value pos() {
		return new Money( +this.value );
	}
}
