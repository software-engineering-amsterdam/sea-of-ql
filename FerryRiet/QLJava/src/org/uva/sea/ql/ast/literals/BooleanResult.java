package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;

public class BooleanResult implements Result {
	private boolean value;

	public BooleanResult(boolean bol) {
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
		value = string.equals("true") ? true : false ;
		return this ;
	}

}
