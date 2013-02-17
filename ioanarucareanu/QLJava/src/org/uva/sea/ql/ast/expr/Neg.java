package org.uva.sea.ql.ast.expr;


import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.semanticchecker.ReturnType;

public class Neg extends Unary {

	public Neg(Expr expr) {
		super(expr);
	}

	@Override
	public ReturnType accept(ExpressionVisitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
