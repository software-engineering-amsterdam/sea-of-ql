package org.uva.sea.ql.ast.expression.unary.bool;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.UnaryExpr;

public class Not extends UnaryExpr {
	
	public Not(final Expression expr){
		super(expr);
	}
	
}
