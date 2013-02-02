package org.uva.sea.ql.ast.expressions.unary;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Numeric;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.expressions.literal.Ident;

public class Neg extends UnaryExpr {
	public Neg(Expr expr) {
		super(expr);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}
}