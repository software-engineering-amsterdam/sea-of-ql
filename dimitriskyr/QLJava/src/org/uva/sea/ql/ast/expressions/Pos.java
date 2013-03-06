package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.visitor.ICheckExprVisitor;

public class Pos extends UnaryExpression {

	public Pos(Expr value) {
		super(value);
	}

	@Override
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new NumericType();
	}
}
