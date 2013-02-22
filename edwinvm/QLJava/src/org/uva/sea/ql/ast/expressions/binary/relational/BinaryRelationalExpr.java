package org.uva.sea.ql.ast.expressions.binary.relational;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.TypeEnvironment;

public abstract class BinaryRelationalExpr extends BinaryExpr {
	protected BinaryRelationalExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new Bool();
	}
}