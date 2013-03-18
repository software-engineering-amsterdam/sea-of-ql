package org.uva.sea.ql.value;

import org.uva.sea.ql.ast.type.TextType;

public class TextValue implements Value {
	
	private final String value;
	
	public TextValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public TextType getType() {
		return new TextType();
	}

	@Override
	public Value add(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value addInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value addMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value and(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value andBool(BooleanValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value div(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value divInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value divMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value eq(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value eqInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value eqMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value eqBool(BooleanValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value geq(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value geqInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value geqMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value gt(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value gtInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value gtMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value leq(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value leqInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value leqMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value lt(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value ltInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value ltMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value mul(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value mulInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value mulMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value neq(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value neqInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value neqMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value neqBool(BooleanValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value or(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value orBool(BooleanValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value sub(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value subInteger(IntegerValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value subMoney(MoneyValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value neg() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value not() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value pos() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return value;
	}

}
