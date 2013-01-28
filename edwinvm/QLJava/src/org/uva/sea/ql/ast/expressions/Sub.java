package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class Sub extends Binary {
	public Sub(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}