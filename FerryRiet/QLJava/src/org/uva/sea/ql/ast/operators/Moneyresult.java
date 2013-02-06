package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.TypeDescription;

import org.uva.sea.ql.ast.types.MoneyType;

public class MoneyResult implements ExpressionResult {
	private BigDecimal value;

	public MoneyResult(BigDecimal val) {
		value = val;
	}

	public MoneyResult(Integer val) {
		value = new BigDecimal(val);
	}

	public int getIntegerValue() {
		return 1;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String toString() {
		return value.toString();
	}

	@Override
	public TypeDescription typeOf() {
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
	public ExpressionResult setValue(String string) {
		try {
		value = new BigDecimal(string); 
		}
		catch (java.lang.NumberFormatException e) {
			System.out.println("BigDecimal convert error");
			value = new BigDecimal(0); 
		}
		return this ;
	}
}