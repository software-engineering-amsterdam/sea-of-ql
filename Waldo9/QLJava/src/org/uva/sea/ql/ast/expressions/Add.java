package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;

public class Add extends Binary {

	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
    }
	
	@Override
	public Type typeOf(Map<String, Type> typeEnvironment) {
		return new IntType();
	}
	
}
