package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.Expr;

public class Or extends Binary {

	public Or(Expr result, Expr rhs) {
		super(result, rhs);
	}

}
