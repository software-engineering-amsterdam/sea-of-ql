package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.parser.SupportedTypes;

public abstract class BinaryArithmeticExpr extends BinaryExpr {
	protected BinaryArithmeticExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type typeOf(SupportedTypes supportedTypes) {
		return new Numeric();
	}
}