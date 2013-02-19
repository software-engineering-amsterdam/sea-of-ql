package org.uva.sea.ql.ast.expressions.binaryExpr;

import java.util.Map;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.visitor.ExprVisitor;

public class Mul extends BinaryExpr {

	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
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