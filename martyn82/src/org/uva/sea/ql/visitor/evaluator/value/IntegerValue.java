package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.IntegerType;

public class IntegerValue extends NumberValue {
	private final Integer value;

	public IntegerValue( Integer value ) {
		super( value );
		this.value = value;
	}

	@Override
	public IntegerType getType() {
		return IntegerType.INTEGER;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}

	@Override
	public Value add( Value value ) {
		return value.add( this );
	}

	@Override
	protected Value add( IntegerValue value ) {
		return new IntegerValue( value.getValue() + this.value );
	}

	@Override
	protected Value add( MoneyValue value ) {
		return new MoneyValue( value.getValue() + this.value );
	}

	@Override
	public Value sub( Value value ) {
		return value.sub( this );
	}

	@Override
	protected Value sub( IntegerValue value ) {
		return new IntegerValue( value.getValue() - this.value );
	}

	@Override
	protected Value sub( MoneyValue value ) {
		return new MoneyValue( value.getValue() - this.value );
	}

	@Override
	public Value div( Value value ) {
		return value.div( this );
	}

	@Override
	protected Value div( IntegerValue value ) {
		return new IntegerValue( value.getValue() / this.value );
	}

	@Override
	protected Value div( MoneyValue value ) {
		return new MoneyValue( value.getValue() / this.value );
	}

	@Override
	public Value mul( Value value ) {
		return value.mul( this );
	}

	@Override
	protected Value mul( IntegerValue value ) {
		return new IntegerValue( value.getValue() * this.value );
	}

	@Override
	protected Value mul( MoneyValue value ) {
		return new MoneyValue( value.getValue() * this.value );
	}

	@Override
	public Value geq( Value value ) {
		return value.geq( this );
	}

	@Override
	protected Value geq( IntegerValue value ) {
		return new BooleanValue( value.getValue() >= this.value );
	}

	@Override
	protected Value geq( MoneyValue value ) {
		return new BooleanValue( value.getValue() >= this.value );
	}

	@Override
	public Value gt( Value value ) {
		return value.gt( this );
	}

	@Override
	protected Value gt( IntegerValue value ) {
		return new BooleanValue( value.getValue() > this.value );
	}

	@Override
	protected Value gt( MoneyValue value ) {
		return new BooleanValue( value.getValue() > this.value );
	}

	@Override
	public Value leq( Value value ) {
		return value.leq( this );
	}

	@Override
	protected Value leq( IntegerValue value ) {
		return new BooleanValue( value.getValue() <= this.value );
	}

	@Override
	protected Value leq( MoneyValue value ) {
		return new BooleanValue( value.getValue() <= this.value );
	}

	@Override
	public Value lt( Value value ) {
		return value.lt( this );
	}

	@Override
	protected Value lt( IntegerValue value ) {
		return new BooleanValue( value.getValue() < this.value );
	}

	@Override
	protected Value lt( MoneyValue value ) {
		return new BooleanValue( value.getValue() < this.value );
	}

	@Override
	public Value neg() {
		return new IntegerValue( -this.value );
	}

	@Override
	public Value pos() {
		return new IntegerValue( +this.value );
	}
}
