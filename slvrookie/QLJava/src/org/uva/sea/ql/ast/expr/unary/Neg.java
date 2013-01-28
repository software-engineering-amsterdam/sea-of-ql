package org.uva.sea.ql.ast.expr.unary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class Neg extends UnaryExpr {

	public Neg(Expr arg) {
		super(arg);
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new Numeric();
	}

	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
