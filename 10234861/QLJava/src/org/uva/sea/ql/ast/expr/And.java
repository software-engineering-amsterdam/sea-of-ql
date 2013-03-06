package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.IExprVisitor;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;

public class And extends BinaryExpr {

	public And (Expr result, Expr rhs){
		super(result,rhs);
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type isOfType(Map<String, Type> typeEnv){
		return new NumericType();
	}
}

