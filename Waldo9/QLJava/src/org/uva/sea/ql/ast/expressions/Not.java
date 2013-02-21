package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;

public class Not extends Unary {

	public Not(Expr x) {
		super(x);
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
    }
	
	@Override
	public Type typeOf(Map<String, Type> typeEnvironment) {
		return new BoolType();
	}

}
