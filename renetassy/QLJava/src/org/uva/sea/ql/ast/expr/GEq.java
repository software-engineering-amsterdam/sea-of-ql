package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.IExprVisitor;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;


public class GEq extends Binary {

	public GEq(Expr result, Expr rhs) {
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
