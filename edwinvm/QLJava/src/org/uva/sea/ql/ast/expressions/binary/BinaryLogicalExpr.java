package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.parser.SupportedTypes;

public abstract class BinaryLogicalExpr extends BinaryExpr {
	protected BinaryLogicalExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type typeOf(SupportedTypes supportedTypes) {
		return new Bool();
	}
}