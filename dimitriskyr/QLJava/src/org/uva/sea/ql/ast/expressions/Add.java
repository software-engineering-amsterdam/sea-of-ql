package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Add extends BinaryExpression{
	public Add (Expr lhs, Expr rhs){
		super(lhs,rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new NumericType();
	}

	@Override
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return  visitor.visit(this);
	}	
	
}
