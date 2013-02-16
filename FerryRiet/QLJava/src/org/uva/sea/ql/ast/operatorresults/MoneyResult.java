package org.uva.sea.ql.ast.operatorresults;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;

public class MoneyResult extends Result {
	private BigDecimal value;

	public MoneyResult(BigDecimal val) {
		super(new MoneyType());
		value = val;
	}

	public MoneyResult(Integer val) {
		super(new MoneyType());
		value = new BigDecimal(val);
	}

	public int getIntegerValue() {
		return value.intValue();
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String toString() {
		return value.toString();
	}

	@Override
	public Type typeOf() {
		return new MoneyType();
	}

	@Override
	public BigDecimal getMoneyValue() {
		return value;
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}

	@Override
	public String getStringValue() {
		return value.toString();
	}

	@Override
	public Result setValue(String string) {
		try {
			value = new BigDecimal(string);
		} catch (java.lang.NumberFormatException e) {
			System.out.println("BigDecimal convert error");
			value = new BigDecimal(0);
		}
		return this;
	}

	public Result add(Result adder) {
		return adder.doAdd(this);
	}

	public Result doAdd(MoneyResult money) {
		return new MoneyResult(money.getMoneyValue().add(this.getMoneyValue()));
	}

	public Result doAdd(IntegerResult inte) {
		return new MoneyResult((this.getMoneyValue()).add(new BigDecimal(inte
				.getIntegerValue())));
	}

	public Result sub(Result subber) {
		return subber.doSub(this);
	}

	public Result doSub(MoneyResult subber) {
		return new MoneyResult(subber.getMoneyValue().subtract(
				this.getMoneyValue()));
	}

	public Result doSub(IntegerResult subber) {
		return new MoneyResult(
				new BigDecimal(subber.getIntegerValue()).subtract(this
						.getMoneyValue()));
	}

	@Override
	public Result mul(Result muller) {
		return muller.doMul(this);
	}

	@Override
	public Result doMul(MoneyResult money) {
		return new MoneyResult(money.getMoneyValue().multiply(
				this.getMoneyValue()));
	}

	@Override
	public Result doMul(IntegerResult inte) {
		return new MoneyResult((this.getMoneyValue()).multiply(new BigDecimal(
				inte.getIntegerValue())));
	}

	@Override
	public Result div(Result muller) {
		return muller.doDiv(this);
	}

	@Override
	public Result doDiv(MoneyResult diver) {
		Result result;
		try {
			result = new MoneyResult(diver.getMoneyValue().divide(
					this.getMoneyValue()));
		} catch (ArithmeticException e) {
			result = new MoneyResult(0);
		}
		return result;
	}

	@Override
	public Result doDiv(IntegerResult diver) {
		Result result;
		try {
			result = new MoneyResult(
					new BigDecimal(diver.getIntegerValue())
							.divide(getMoneyValue()));
		} catch (ArithmeticException e) {
			result = new MoneyResult(0);
		}
		return result;
	}

	@Override
	public Result eq(Result equ) {
		return equ.doEq(this);
	}

	@Override
	public Result doEq(MoneyResult equ) {
		return new BooleanResult(equ.getMoneyValue().compareTo(
				this.getMoneyValue()) == 0);
	}

	@Override
	public Result doEq(IntegerResult equ) {
		return new BooleanResult(this.getMoneyValue().compareTo(
				new BigDecimal(equ.getIntegerValue())) == 0);
	}

	@Override
	public Result doEq(BooleanResult equ) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Result neq(Result equ) {
		return equ.doNeq(this);
	}

	@Override
	public Result doNeq(MoneyResult equ) {
		return new BooleanResult(equ.getMoneyValue().compareTo(
				this.getMoneyValue()) != 0);
	}

	@Override
	public Result doNeq(IntegerResult equ) {
		return new BooleanResult(this.getMoneyValue().compareTo(
				new BigDecimal(equ.getIntegerValue())) != 0);
	}

	@Override
	public Result doNeq(BooleanResult equ) {
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
		return g.doGeq(this);
	}

	@Override
	public Result doGeq(MoneyResult g) {
		return new BooleanResult(g.getMoneyValue().compareTo(
				this.getMoneyValue()) >= 0);
	}

	@Override
	public Result doGeq(IntegerResult g) {
		return new BooleanResult(
				(new BigDecimal(g.getIntegerValue()).compareTo(this
						.getMoneyValue())) >= 0);
	}

	@Override
	public Result gt(Result g) {
		return g.doGt(this);
	}

	@Override
	public Result doGt(MoneyResult g) {
		return new BooleanResult(g.getMoneyValue().compareTo(
				this.getMoneyValue()) > 0);
	}

	@Override
	public Result doGt(IntegerResult g) {
		return new BooleanResult(
				(new BigDecimal(g.getIntegerValue()).compareTo(this
						.getMoneyValue())) > 0);
	}

	@Override
	public Result lt(Result g) {
		return g.doLt(this);
	}

	@Override
	public Result doLt(MoneyResult g) {
		return new BooleanResult(g.getMoneyValue().compareTo(
				this.getMoneyValue()) < 0);
	}

	@Override
	public Result doLt(IntegerResult g) {
		return new BooleanResult(
				(new BigDecimal(g.getIntegerValue()).compareTo(this
						.getMoneyValue())) < 0);
	}

	@Override
	public Result leq(Result g) {
		return g.doLeq(this);
	}

	@Override
	public Result doLeq(MoneyResult g) {
		return new BooleanResult(g.getMoneyValue().compareTo(
				this.getMoneyValue()) <= 0);
	}

	@Override
	public Result doLeq(IntegerResult g) {
		return new BooleanResult(
				(new BigDecimal(g.getIntegerValue()).compareTo(this
						.getMoneyValue())) <= 0);
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
