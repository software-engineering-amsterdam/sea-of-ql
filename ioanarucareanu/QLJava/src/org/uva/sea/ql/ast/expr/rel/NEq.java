package org.uva.sea.ql.ast.expr.rel;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;

public class NEq extends Binary {

	public NEq(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}
}
