package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Ident extends Value {

	private final String value;

	public Ident(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Type typeOf(Map<String, Type> typeEnv) {
		if (typeEnv.containsKey(this.getValue())) {
			return typeEnv.get(this.getValue());
		}
		return new ErrorType();
	}
}
