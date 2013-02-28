package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.visitor.ICheckExprVisitor;

import java.lang.String;
import java.util.Map;

public class String_lit extends Value {
	private final String value;

	public String_lit(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Type typeOf(Map<String, Type> typeEnv) {
		return new StringType();
	}
}
