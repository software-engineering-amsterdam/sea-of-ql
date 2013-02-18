package org.uva.sea.ql.ast.expressions.unaryExpr;

import java.util.Map;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.visitor.ExprVisitor;

public class Neg extends UnaryExpr {

	public Neg(Expr unExpr) {
		super(unExpr);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.IntType();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}