package org.uva.sea.ql.evaluator.value;

/**
 * Represents an abstract value.
 */
abstract public class Value {
	/**
	 * Retrieves the value of the instance.
	 *
	 * @return The value.
	 */
	abstract public Object getValue();

	// arithmetic

	/**
	 * Addition operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value add( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Addition operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value add( Integer value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Addition operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value add( Money value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Subtraction operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value sub( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Subtraction operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value sub( Integer value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Subtraction operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value sub( Money value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Division operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value div( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Division operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value div( Integer value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Division operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value div( Money value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Multiplication operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value mul( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * The multiplication operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value mul( Integer value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Multiplication operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value mul( Money value ) {
		throw new UnsupportedOperationException();
	}

	// binary logical

	/**
	 * Logical AND operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value and( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Logical AND operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value and( Boolean value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Logical OR operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value or( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Logical OR operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value or( Boolean value ) {
		throw new UnsupportedOperationException();
	}

	// unary logical

	/**
	 * Logical NOT operation.
	 *
	 * @return The result.
	 */
	public Value not() {
		throw new UnsupportedOperationException();
	}

	// object comparison

	/**
	 * Equation operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value eq( Value value ) {
		return new Boolean( value.getValue().equals( this.getValue() ) );
	}

	/**
	 * Non-equation operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value neq( Value value ) {
		return new Boolean( !value.getValue().equals( this.getValue() ) );
	}

	// numeric comparisons

	/**
	 * Greater-than-equals operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value geq( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Greater-than-equals operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value geq( Integer value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Greater-than-equals operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value geq( Money value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Greater-than operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value gt( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Greater-than operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value gt( Integer value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Greater-than operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value gt( Money value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Lesser-than-equals operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value leq( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Lesser-than-equals operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value leq( Integer value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Lesser-than-equals operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value leq( Money value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Lesser-than operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value lt( Value value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Lesser-than operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value lt( Integer value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Lesser-than operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value lt( Money value ) {
		throw new UnsupportedOperationException();
	}

	// unary numeric

	/**
	 * Negate operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value neg() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Positive operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value pos() {
		throw new UnsupportedOperationException();
	}
}
