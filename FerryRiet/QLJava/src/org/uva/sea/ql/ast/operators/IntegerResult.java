package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.TypeDescription;
import org.uva.sea.ql.ast.types.IntegerType;

public class IntegerResult implements ExpressionResult {
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
	public TypeDescription typeOf() {
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
}
