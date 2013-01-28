package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class Mul extends Binary {
	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}