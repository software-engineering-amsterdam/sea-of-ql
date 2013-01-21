package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;

public class StringNode extends Expr {

	private final java.lang.String value;

	public StringNode(java.lang.String value) {
		this.value = value;
	}

	public java.lang.String getValue() {
		return value;
	}

	@Override
	public Value eval() {
		return new org.uva.sea.ql.ast.values.StringValue(value);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.StringType();
	}

}
