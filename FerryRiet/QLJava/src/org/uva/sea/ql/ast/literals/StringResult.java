package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;

public class StringResult extends Result {
	private String value;

	public StringResult(String string) {
		super(new StringType());
		value = string;
	}

	public String toString() {
		return value;
	}

	@Override
	public int getIntegerValue() {
		return 0;
	}

	@Override
	public Type typeOf() {
		return new StringType();
	}

	@Override
	public BigDecimal getMoneyValue() {
		return null;
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}

	@Override
	public String getStringValue() {
		return value;
	}

	@Override
	public Result setValue(String string) {
		value = string;
		return this;
	}

	@Override
	public boolean isCompatibleToInt() {
		return false;
	}

	@Override
	public boolean isCompatibleToString() {
		return true;
	}

	@Override
	public boolean isCompatibleToBool() {
		return false;
	}

	@Override
	public boolean isCompatibleToMoney() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result add(Result adder) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doAdd(MoneyResult inte) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doAdd(IntegerResult inte) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result mul(Result adder) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doMul(MoneyResult inte) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doMul(IntegerResult inte) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result div(Result adder) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doDiv(MoneyResult inte) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doDiv(IntegerResult inte) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result sub(Result subber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doSub(MoneyResult subber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doSub(IntegerResult subber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result eq(Result eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doEq(MoneyResult eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doEq(IntegerResult eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doEq(BooleanResult eq) {
		throw new UnsupportedOperationException();
	}
}
