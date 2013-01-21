package org.uva.sea.ql.ast.expr.unary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Pos extends Unary {

	public Pos(Expr arg) {
		super(arg);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BooleanType();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
