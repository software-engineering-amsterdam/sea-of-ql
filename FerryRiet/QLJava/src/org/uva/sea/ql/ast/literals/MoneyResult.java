package org.uva.sea.ql.ast.literals;

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
		return new MoneyResult(subber.getMoneyValue().subtract(this.getMoneyValue()));
	}

	public Result doSub(IntegerResult subber) {
		return new MoneyResult(new BigDecimal(subber.getIntegerValue()).subtract(this.getMoneyValue()));
	}

	@Override
	public Result mul(Result muller) {
		return muller.doMul(this);
	}

	@Override
	public Result doMul(MoneyResult money) {
		return new MoneyResult(money.getMoneyValue().multiply(this.getMoneyValue()));
	}

	@Override
	public Result doMul(IntegerResult inte) {
		return new MoneyResult((this.getMoneyValue()).multiply(new BigDecimal(inte
				.getIntegerValue())));
	}

	@Override
	public Result div(Result muller) {
		return muller.doDiv(this);
	}

	@Override
	public Result doDiv(MoneyResult diver) {
		Result result;
		try {
			result = new MoneyResult(diver.getMoneyValue().divide(this.getMoneyValue()));
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
					new BigDecimal(diver.getIntegerValue()).divide(getMoneyValue()));
		} catch (ArithmeticException e) {
			result = new MoneyResult(0);
		}
		return result;
	}
}
