package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.TypeDescription;

import org.uva.sea.ql.ast.types.StringType;

public class StringResult implements ExpressionResult {
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
	public TypeDescription typeOf() {
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
	public ExpressionResult setValue(String string) {
		value = string;
		return this;
	}
}
