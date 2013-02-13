package org.uva.sea.ql.ast.operatorresults;

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

	@Override
	public Result neq(Result eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doNeq(MoneyResult eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doNeq(IntegerResult eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doNeq(BooleanResult eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result and(Result eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doAnd(BooleanResult ander) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result geq(Result g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doGeq(MoneyResult g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doGeq(IntegerResult g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result gt(Result g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doGt(MoneyResult g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doGt(IntegerResult g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result lt(Result g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doLt(MoneyResult g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doLt(IntegerResult g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result leq(Result g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doLeq(MoneyResult g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doLeq(IntegerResult g) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result or(Result eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doOr(BooleanResult ander) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result not(Result eq) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doNot(BooleanResult ander) {
		throw new UnsupportedOperationException();
	}
}
