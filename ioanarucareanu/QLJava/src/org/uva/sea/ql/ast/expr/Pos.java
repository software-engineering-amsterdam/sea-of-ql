package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.semanticchecker.ReturnType;

public class Pos extends Unary {

	public Pos (Expr leftExpr){
		super(leftExpr);
	}

	@Override
	public ReturnType accept(ExpressionVisitor visitor) {
		
		return null;
	}
	
}
