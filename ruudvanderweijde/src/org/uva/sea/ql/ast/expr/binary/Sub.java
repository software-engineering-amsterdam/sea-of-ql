package org.uva.sea.ql.ast.expr.binary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Sub extends Binary {

	public Sub(Expr lhs, Expr rhs) {
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
