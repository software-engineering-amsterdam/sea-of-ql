package org.uva.sea.ql.ast.expr.value;

import java.util.Map;

import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class StringLiteral extends Value {

	private final String value;

	public StringLiteral(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new StringType();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ExprVisitor) {
		return ExprVisitor.visit(this);
	}

}
