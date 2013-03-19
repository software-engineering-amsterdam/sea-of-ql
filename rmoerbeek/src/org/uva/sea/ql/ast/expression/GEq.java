package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.ExpressionVisitor;

public class GEq extends Binary {

	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.BooleanType();
	}
	
	@Override 
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
