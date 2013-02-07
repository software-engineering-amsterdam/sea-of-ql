package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.Type;

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

	/**
	 * Retrieves the type of the value instance.
	 *
	 * @return The type.
	 */
	abstract public Type getType();

	/**
	 * Determines whether the value is defined.
	 *
	 * @return True if the value is defined, false otherwise.
	 */
	public boolean isDefined() {
		return true;
	}

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
	protected Value add( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Addition operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	protected Value add( MoneyValue value ) {
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
	protected Value sub( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Subtraction operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	protected Value sub( MoneyValue value ) {
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
	protected Value div( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Division operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	protected Value div( MoneyValue value ) {
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
	protected Value mul( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Multiplication operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	protected Value mul( MoneyValue value ) {
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
	protected Value and( BooleanValue value ) {
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
	protected Value or( BooleanValue value ) {
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
		return new BooleanValue( value.getValue().equals( this.getValue() ) );
	}

	/**
	 * Non-equation operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	public Value neq( Value value ) {
		return new BooleanValue( !value.getValue().equals( this.getValue() ) );
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
	protected Value geq( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Greater-than-equals operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	protected Value geq( MoneyValue value ) {
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
	protected Value gt( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Greater-than operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	protected Value gt( MoneyValue value ) {
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
	protected Value leq( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Lesser-than-equals operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	protected Value leq( MoneyValue value ) {
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
	protected Value lt( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Lesser-than operation.
	 *
	 * @param value
	 *
	 * @return The result.
	 */
	protected Value lt( MoneyValue value ) {
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
