package org.uva.sea.ql.ast.expr.value;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;


public class StringLiteral extends Expr {

	private final String value;

	public StringLiteral(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new StringType();
	}


}
