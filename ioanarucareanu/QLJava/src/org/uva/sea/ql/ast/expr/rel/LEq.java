package org.uva.sea.ql.ast.expr.rel;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;

public class LEq extends Binary {

	public LEq(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr) ;
	}

}
