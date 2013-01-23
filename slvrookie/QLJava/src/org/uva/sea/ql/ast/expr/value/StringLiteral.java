package org.uva.sea.ql.ast.expr.value;

import java.util.Map;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IVisitor;


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

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
