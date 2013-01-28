package org.uva.sea.ql.eval.value;

/**
 * Represents an abstract value.
 */
abstract public class Value {

	// arithmetic

	public Value add( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value add( Integer value ) {
		throw new UnsupportedOperationException();
	}

	public Value add( Money value ) {
		throw new UnsupportedOperationException();
	}

	public Value sub( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value sub( Integer value ) {
		throw new UnsupportedOperationException();
	}

	public Value sub( Money value ) {
		throw new UnsupportedOperationException();
	}

	public Value div( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value div( Integer value ) {
		throw new UnsupportedOperationException();
	}

	public Value div( Money value ) {
		throw new UnsupportedOperationException();
	}

	public Value mul( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value mul( Integer value ) {
		throw new UnsupportedOperationException();
	}

	public Value mul( Money value ) {
		throw new UnsupportedOperationException();
	}

	// binary logical

	public Value and( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value and( Boolean value ) {
		throw new UnsupportedOperationException();
	}

	public Value or( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value or( Boolean value ) {
		throw new UnsupportedOperationException();
	}

	// unary logical

	public Value not() {
		throw new UnsupportedOperationException();
	}

	// object comparison

	public Value eq( Value value ) {
		return new Boolean( value.getValue().equals( this.getValue() ) );
	}

	public Value neq( Value value ) {
		return new Boolean( !value.getValue().equals( this.getValue() ) );
	}

	// numeric comparisons

	public Value geq( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value geq( Integer value ) {
		throw new UnsupportedOperationException();
	}

	public Value geq( Money value ) {
		throw new UnsupportedOperationException();
	}

	public Value gt( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value gt( Integer value ) {
		throw new UnsupportedOperationException();
	}

	public Value gt( Money value ) {
		throw new UnsupportedOperationException();
	}

	public Value leq( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value leq( Integer value ) {
		throw new UnsupportedOperationException();
	}

	public Value leq( Money value ) {
		throw new UnsupportedOperationException();
	}

	public Value lt( Value value ) {
		throw new UnsupportedOperationException();
	}

	public Value lt( Integer value ) {
		throw new UnsupportedOperationException();
	}

	public Value lt( Money value ) {
		throw new UnsupportedOperationException();
	}

	// unary numeric

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieves the value of the instance.
	 *
	 * @return The value.
	 */
	abstract public Object getValue();
}
