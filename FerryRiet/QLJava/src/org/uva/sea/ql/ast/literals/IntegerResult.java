package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.IntegerType;

public class IntegerResult extends Result<Integer> {
	private Integer value;

	public IntegerResult(int val) {
		value = new Integer(val);
	}

	public int getIntegerValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String toString() {
		return value.toString();
	}

	@Override
	public Type typeOf() {
		return new IntegerType();
	}

	@Override
	public BigDecimal getMoneyValue() {
		return new BigDecimal(value);
	}

	@Override
	public boolean getBooleanValue() {
		return value == 0;
	}

	@Override
	public String getStringValue() {
		return value.toString();
	}

	@Override
	public Result setValue(String string) {
		try {
			value = Integer.parseInt(string);
		} catch (java.lang.NumberFormatException e) {
			System.out.println("Format error in ints");
			value = 0;
		}

		return this;
	}

	@Override
	public boolean isCompatibleToInt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompatibleToString() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompatibleToBool() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompatibleToMoney() {
		// TODO Auto-generated method stub
		return false;
	}
}
