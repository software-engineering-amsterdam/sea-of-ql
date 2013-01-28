package org.uva.sea.ql.ast.operators;

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
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TypeDescription typeOf() {
		return new StringType();
	}
}
