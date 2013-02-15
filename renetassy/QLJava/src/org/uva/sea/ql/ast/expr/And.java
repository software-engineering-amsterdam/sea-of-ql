package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.IExprVisitor;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;

public class And extends Binary {

	public And(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new BoolType();
	}

}
