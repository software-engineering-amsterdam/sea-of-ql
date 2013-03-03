package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.Expression;

public abstract class QLValue extends Expression {
	
	public Integer getIntegerValue() {
		throw new UnsupportedOperationException();
	}

	public Boolean getBooleanValue() {
		throw new UnsupportedOperationException();
	}

	public String getStringValue() {
		throw new UnsupportedOperationException();
	}
}
