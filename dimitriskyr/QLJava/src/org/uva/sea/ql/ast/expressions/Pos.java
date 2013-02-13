package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Pos extends UnaryExpression {
	
	public Pos(Expr value){
		super(value);
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
