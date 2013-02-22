package org.uva.sea.ql.ast.expressions.binary.arithmetic;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.TypeEnvironment;

public abstract class BinaryArithmeticExpr extends BinaryExpr {
	protected BinaryArithmeticExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new Numeric();
	}
}