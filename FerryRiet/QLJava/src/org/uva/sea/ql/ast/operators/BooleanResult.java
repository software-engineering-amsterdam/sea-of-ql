package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.TypeDescription;

public class BooleanResult implements ExpressionResult {
	private boolean value;

	public BooleanResult(boolean bol) {
		value = bol;
	}

	@Override
	public int getIntegerValue() {
		return 0;
	}

	@Override
	public TypeDescription typeOf() {
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

}
