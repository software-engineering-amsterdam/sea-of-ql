package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class And extends Binary {
	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}