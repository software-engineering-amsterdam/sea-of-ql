package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;

public class StringValue extends Expr {

	private final Integer value;

	public StringValue(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.TypeString();
	}

}
