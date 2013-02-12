package org.uva.sea.ql.ast.operatorresults;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;

public class BooleanResult extends Result {
	private boolean value;

	public BooleanResult(boolean bol) {
		super(new BooleanType());
		value = bol;
	}

	@Override
	public int getIntegerValue() {
		return 0;
	}

	@Override
	public Type typeOf() {
		return new BooleanType();
	}

	@Override
	public BigDecimal getMoneyValue() {
		return null;
	}

	@Override
	public boolean getBooleanValue() {
		return value;
	}

	@Override
	public String getStringValue() {
		return value == true ? new String("true") : new String("false");
	}

	@Override
	public Result setValue(String string) {
		value = string.equals("true") ? true : false;
		return this;
	}

	@Override
	public String toString() {
		return value == true ? new String("true") : new String("false");
	}

	@Override
	public boolean isCompatibleToInt() {
		return false;
	}

	@Override
	public boolean isCompatibleToString() {
		return false;
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return false;
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
	public Result eq(Result equ) {
		return equ.doEq(this);
	}

	@Override
	public Result doEq(MoneyResult equ) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doEq(IntegerResult equ) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result doEq(BooleanResult equ) {
		return new BooleanResult(
				equ.getBooleanValue() == this.getBooleanValue());
	}

	@Override
	public Result and(Result dand) {
		return dand.doAnd(this);
	}

	@Override
	public Result doAnd(BooleanResult ander) {
		return new BooleanResult(ander.getBooleanValue()
				&& this.getBooleanValue());
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
	public Result or(Result dor) {
		return dor.doOr(this);
	}

	@Override
	public Result doOr(BooleanResult ander) {
		return new BooleanResult(ander.getBooleanValue()
				|| this.getBooleanValue());
	}

}
