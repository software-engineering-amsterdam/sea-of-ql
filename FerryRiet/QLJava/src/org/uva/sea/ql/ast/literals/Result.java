package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.Type;

public abstract class Result {
	private Type resultType ;
	
	public Result(Type rt) {
		resultType = rt ;
	}
	
	public abstract String toString();

	public abstract int getIntegerValue();

	public abstract String getStringValue();

	public abstract BigDecimal getMoneyValue();

	public abstract boolean getBooleanValue();

	public abstract Type typeOf();

	public boolean isCompatibleToInt() {
		return resultType.isCompatibleToInt() ;
	}

	public boolean isCompatibleToString() {
		return resultType.isCompatibleToString();
	}

	public boolean isCompatibleToBool() {
		return resultType.isCompatibleToBool();
	}

	public boolean isCompatibleToMoney() {
		return resultType.isCompatibleToMoney() ;
	}

	public abstract Result setValue(String string) ;
}
