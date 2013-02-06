package org.uva.sea.ql.ast.expr.rel;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;

public class Eq extends Binary {

	public Eq(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}
}
