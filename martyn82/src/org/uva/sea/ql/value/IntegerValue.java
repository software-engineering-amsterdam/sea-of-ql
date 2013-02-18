package org.uva.sea.ql.value;

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
	public String toString() {
		return Integer.toString( this.value );
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
	public Value subtract( Value value ) {
		return value.subtract( this );
	}

	@Override
	protected Value subtract( IntegerValue value ) {
		return new IntegerValue( value.getValue() - this.value );
	}

	@Override
	protected Value subtract( MoneyValue value ) {
		return new MoneyValue( value.getValue() - this.value );
	}

	@Override
	public Value divide( Value value ) {
		return value.divide( this );
	}

	@Override
	protected Value divide( IntegerValue value ) {
		return new IntegerValue( value.getValue() / this.value );
	}

	@Override
	protected Value divide( MoneyValue value ) {
		return new MoneyValue( value.getValue() / this.value );
	}

	@Override
	public Value multiply( Value value ) {
		return value.multiply( this );
	}

	@Override
	protected Value multiply( IntegerValue value ) {
		return new IntegerValue( value.getValue() * this.value );
	}

	@Override
	protected Value multiply( MoneyValue value ) {
		return new MoneyValue( value.getValue() * this.value );
	}

	@Override
	public Value greaterThanOrEquals( Value value ) {
		return value.greaterThanOrEquals( this );
	}

	@Override
	protected Value greaterThanOrEquals( IntegerValue value ) {
		return new BooleanValue( value.getValue() >= this.value );
	}

	@Override
	protected Value greaterThanOrEquals( MoneyValue value ) {
		return new BooleanValue( value.getValue() >= this.value );
	}

	@Override
	public Value greaterThan( Value value ) {
		return value.greaterThan( this );
	}

	@Override
	protected Value greaterThan( IntegerValue value ) {
		return new BooleanValue( value.getValue() > this.value );
	}

	@Override
	protected Value greaterThan( MoneyValue value ) {
		return new BooleanValue( value.getValue() > this.value );
	}

	@Override
	public Value lesserThanOrEquals( Value value ) {
		return value.lesserThanOrEquals( this );
	}

	@Override
	protected Value lesserThanOrEquals( IntegerValue value ) {
		return new BooleanValue( value.getValue() <= this.value );
	}

	@Override
	protected Value lesserThanOrEquals( MoneyValue value ) {
		return new BooleanValue( value.getValue() <= this.value );
	}

	@Override
	public Value lesserThan( Value value ) {
		return value.lesserThan( this );
	}

	@Override
	protected Value lesserThan( IntegerValue value ) {
		return new BooleanValue( value.getValue() < this.value );
	}

	@Override
	protected Value lesserThan( MoneyValue value ) {
		return new BooleanValue( value.getValue() < this.value );
	}

	@Override
	public Value negative() {
		return new IntegerValue( -this.value );
	}

	@Override
	public Value positive() {
		return new IntegerValue( +this.value );
	}
}
