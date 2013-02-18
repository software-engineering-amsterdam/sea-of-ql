package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.semanticchecker.ReturnType;

public class Not extends Unary {

	public Not(Expr expr) {
		super(expr);
	}
	
	@Override
	public ReturnType accept(ExpressionVisitor visitor) {
		
		return visitor.visit(this);
	}

}
