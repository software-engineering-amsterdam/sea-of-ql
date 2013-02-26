package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class And extends BinaryExpression {

	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new BooleanType();
	}

	@Override
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
