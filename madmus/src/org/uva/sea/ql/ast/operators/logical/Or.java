package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.Binary;

public class Or extends Binary {

	public Or(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
}
