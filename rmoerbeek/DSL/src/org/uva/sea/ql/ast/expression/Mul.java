package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.ExpressionVisitor;

public class Mul extends Binary {
	
	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new NumericType();
	}
	
	@Override 
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
