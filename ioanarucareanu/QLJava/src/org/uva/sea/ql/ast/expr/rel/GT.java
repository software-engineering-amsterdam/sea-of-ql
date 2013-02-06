package org.uva.sea.ql.ast.expr.rel;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;

public class GT extends Binary {

	public GT(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}

}
