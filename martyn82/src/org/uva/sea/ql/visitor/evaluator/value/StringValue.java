package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.StringType;

public class StringValue extends Value {
	private final String value;

	public StringValue( String value ) {
		this.value = value;
	}

	@Override
	public StringType getType() {
		return StringType.STRING;
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
