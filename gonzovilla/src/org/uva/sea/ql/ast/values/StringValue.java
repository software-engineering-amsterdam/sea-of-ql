package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeString;
import org.uva.sea.ql.ast.visitor.VisitorExpressions;

public class StringValue extends Value {

	private final String value;

	public StringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TypeString();
	}

	@Override
	public <T> T accept(VisitorExpressions<T> visitor) {
		return  visitor.visit(this);
	}
	
}