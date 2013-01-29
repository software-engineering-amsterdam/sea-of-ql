package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.TypeDescription;

public interface ExpressionResult {
	String toString();

	int getValue();

	String getStringValue();

	BigDecimal getMoneyValue();

	boolean getBooleanValue();

	TypeDescription typeOf();
}
