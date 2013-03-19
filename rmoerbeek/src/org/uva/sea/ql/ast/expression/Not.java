package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.ExpressionVisitor;

public class Not extends Unary {

	public Not(Expr x) {
		super(x);
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
