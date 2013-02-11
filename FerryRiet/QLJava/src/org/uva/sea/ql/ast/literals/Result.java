package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.Type;

public abstract class Result<T> {
	private T value;

	public T getValue() {
		return value;
	}

	public abstract String toString();

	public abstract int getIntegerValue();

	public abstract String getStringValue();

	public abstract BigDecimal getMoneyValue();

	public abstract boolean getBooleanValue();

	public abstract Type typeOf();

	public abstract Result<T> setValue(String string);

	public abstract boolean isCompatibleToInt() ;
	public abstract boolean isCompatibleToString() ;
	public abstract boolean isCompatibleToBool() ;
	public abstract boolean isCompatibleToMoney() ;

}
