package org.uva.sea.ql.ast.expressions.binary;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Numeric;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.literal.Ident;

public abstract class BinaryNumericExpr extends BinaryExpr {
	protected BinaryNumericExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}
}