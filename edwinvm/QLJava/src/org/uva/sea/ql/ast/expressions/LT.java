package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class LT extends Binary {
	public LT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}