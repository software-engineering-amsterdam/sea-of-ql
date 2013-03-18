package org.uva.sea.ql.value;

import org.uva.sea.ql.ast.type.MoneyType;

public class MoneyValue extends NumericValue {

	private final double value;

	public MoneyValue(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
	@Override
	public MoneyType getType() {
		return new MoneyType();
	}

	@Override
	Number getNumberValue() {
		return Double.valueOf(value);
	}
	
	@Override
	public Value add(Value otherValue) {
		return otherValue.addMoney(this);
	}
	
	@Override
	public Value div(Value otherValue) {
		return otherValue.divMoney(this);
	}
	
	@Override
	public Value eq(Value otherValue) {
		return otherValue.eqMoney(this);
	}
	
	@Override
	public Value geq(Value otherValue) {
		return otherValue.geqMoney(this);
	}
	
	@Override
	public Value gt(Value otherValue) {
		return otherValue.gtMoney(this);
	}
	
	@Override
	public Value leq(Value otherValue) {
		return otherValue.leq(this);
	}
	
	@Override
	public Value lt(Value otherValue) {
		return otherValue.ltMoney(this);
	}

	@Override
	public Value mul(Value otherValue) {
		return otherValue.mulMoney(this);
	}
	
	@Override
	public Value neq(Value otherValue) {
		return otherValue.neqMoney(this);
	}

	@Override
	public Value sub(Value otherValue) {
		return otherValue.subMoney(this);
	}

	@Override
	public Value neg() {
		return new MoneyValue(-value);
	}

	@Override
	public Value pos() {
		return new MoneyValue(+value);
	}

	@Override
	public String toString() {
		return "EU"+value;
	}
	
	

}