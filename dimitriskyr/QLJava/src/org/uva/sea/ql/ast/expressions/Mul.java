package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Mul extends BinaryExpression{

	public Mul (Expr lhs, Expr rhs){
		super(lhs,rhs);
	}

	@Override
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return  visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new NumericType();

	}
}
