package org.uva.sea.ql.ast.expr.rel;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;

public class GEq extends Binary {

	public GEq(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}

}
