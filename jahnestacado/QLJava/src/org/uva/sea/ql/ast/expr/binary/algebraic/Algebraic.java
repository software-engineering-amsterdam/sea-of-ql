package org.uva.sea.ql.ast.expr.binary.algebraic;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Binary;

public abstract class Algebraic extends Binary {
	
	protected Algebraic(Expr leftExpr,Expr rightExpr){
		super(leftExpr,rightExpr);
	}

}
