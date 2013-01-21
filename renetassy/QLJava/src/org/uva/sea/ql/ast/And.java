package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;

public class And extends Binary {

	public And(Expr result, Expr rhs) {
		super(result, rhs);
	}

}
