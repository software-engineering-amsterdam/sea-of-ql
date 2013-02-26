package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Not extends UnaryExpression {

	public Not(Expr value) {
		super(value);
	}

	@Override
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new BooleanType();
	}
}
