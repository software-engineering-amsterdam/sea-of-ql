package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.Type;

import org.uva.sea.ql.ast.types.StringType;

public class StringResult implements Result {
	private String value;

	public StringResult(String string) {
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
}
