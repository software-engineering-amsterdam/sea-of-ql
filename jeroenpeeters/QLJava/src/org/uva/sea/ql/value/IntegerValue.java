package org.uva.sea.ql.value;

import org.uva.sea.ql.ast.type.IntegerType;

public class IntegerValue extends NumericValue {

	private final int value;

	public IntegerValue(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	Number getNumberValue() {
		return Integer.valueOf(value);
	}

	@Override
	public IntegerType getType() {
		return new IntegerType();
	}

	@Override
	public Value add(Value otherValue) {
		return otherValue.addInteger(this);
	}
	
	@Override
	public Value div(Value otherValue) {
		return otherValue.divInteger(this);
	}
	
	@Override
	public Value eq(Value otherValue) {
		return otherValue.eqInteger(this);
	}
	
	@Override
	public Value geq(Value otherValue) {
		return otherValue.geqInteger(this);
	}
	
	@Override
	public Value gt(Value otherValue) {
		return otherValue.gtInteger(this);
	}
	
	@Override
	public Value leq(Value otherValue) {
		return otherValue.leq(this);
	}
	
	@Override
	public Value lt(Value otherValue) {
		return otherValue.ltInteger(this);
	}

	@Override
	public Value mul(Value otherValue) {
		return otherValue.mulInteger(this);
	}
	
	@Override
	public Value neq(Value otherValue) {
		return otherValue.neqInteger(this);
	}

	@Override
	public Value sub(Value otherValue) {
		return otherValue.subInteger(this);
	}

	@Override
	public Value neg() {
		return new IntegerValue(-value);
	}

	@Override
	public Value pos() {
		return new IntegerValue(+value);
	}

	@Override
	public String toString() {
		return ""+value;
	}
	
}