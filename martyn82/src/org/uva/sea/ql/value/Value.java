package org.uva.sea.ql.value;

import org.uva.sea.ql.ast.type.Type;

abstract public class Value {
	abstract public Object getValue();
	abstract public Type getType();

	@Override
	abstract public String toString();

	public boolean isDefined() {
		return true;
	}

	// arithmetic

	public Value add( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value add( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value add( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value subtract( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value subtract( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value subtract( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value divide( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value divide( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value divide( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value multiply( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value multiply( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value multiply( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	// binary logical

	public Value and( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value and( BooleanValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value or( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value or( BooleanValue value ) {
		throw new UnsupportedOperationException();
	}

	// unary logical

	public Value not() {
		throw new UnsupportedOperationException();
	}

	// object comparison

	public Value equalTo( Value value ) {
		return new BooleanValue( value.getValue().equals( this.getValue() ) );
	}

	public Value notEqualTo( Value value ) {
		return new BooleanValue( !value.getValue().equals( this.getValue() ) );
	}

	// numeric comparisons

	public Value greaterThanOrEquals( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value greaterThanOrEquals( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value greaterThanOrEquals( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value greaterThan( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value greaterThan( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value greaterThan( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value lesserThanOrEquals( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value lesserThanOrEquals( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value lesserThanOrEquals( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value lesserThan( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value lesserThan( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value lesserThan( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	// unary numeric

	public Value negative() {
		throw new UnsupportedOperationException();
	}

	public Value positive() {
		throw new UnsupportedOperationException();
	}
}
