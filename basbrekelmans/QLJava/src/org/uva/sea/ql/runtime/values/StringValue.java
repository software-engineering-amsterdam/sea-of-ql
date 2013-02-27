package org.uva.sea.ql.runtime.values;

import org.uva.sea.ql.ast.types.Type;

public class StringValue extends Value {

	private final String value;

	public StringValue(final String value) {
		this.value = value;
	}

	@Override
	public Type getType() {
		return Type.STRING;
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
