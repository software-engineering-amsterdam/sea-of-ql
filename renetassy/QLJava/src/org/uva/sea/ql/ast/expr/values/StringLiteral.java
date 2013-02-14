package org.uva.sea.ql.ast.expr.values;

import java.util.Map;

import org.uva.sea.ql.ExprTypeChecker;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;


public class StringLiteral extends Value {
	
	private final String value;
	
	public StringLiteral(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public boolean accept(ExprTypeChecker visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new StringType();
	}

}
