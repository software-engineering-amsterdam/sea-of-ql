package org.uva.sea.ql.ast.literals;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.Type;

public interface Result {
	String toString();

	int getIntegerValue();

	String getStringValue();

	BigDecimal getMoneyValue();

	boolean getBooleanValue();

	Type typeOf();

	Result setValue(String string);
}
