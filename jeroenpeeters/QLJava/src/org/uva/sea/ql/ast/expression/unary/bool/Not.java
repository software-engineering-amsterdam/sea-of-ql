package org.uva.sea.ql.ast.expression.unary.bool;

import org.uva.sea.ql.ast.expression.BooleanExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.UnaryExpr;

public class Not extends UnaryExpr implements BooleanExpression {
	
	public Not(final Expression expr){
		super(expr);
	}
	
}
