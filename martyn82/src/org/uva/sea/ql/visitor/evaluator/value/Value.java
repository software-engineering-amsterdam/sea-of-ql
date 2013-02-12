package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.Type;

abstract public class Value {
	abstract public Object getValue();
	abstract public Type getType();

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

	public Value sub( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value sub( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value sub( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value div( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value div( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value div( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value mul( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value mul( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value mul( MoneyValue value ) {
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

	public Value eq( Value value ) {
		return new BooleanValue( value.getValue().equals( this.getValue() ) );
	}

	public Value neq( Value value ) {
		return new BooleanValue( !value.getValue().equals( this.getValue() ) );
	}

	// numeric comparisons

	public Value geq( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value geq( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value geq( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value gt( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value gt( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value gt( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value leq( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value leq( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value leq( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	public Value lt( Value value ) {
		throw new UnsupportedOperationException();
	}

	protected Value lt( IntegerValue value ) {
		throw new UnsupportedOperationException();
	}

	protected Value lt( MoneyValue value ) {
		throw new UnsupportedOperationException();
	}

	// unary numeric

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}
}
