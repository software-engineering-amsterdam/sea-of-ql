package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class LEq extends BinaryExpression {

	public LEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
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
