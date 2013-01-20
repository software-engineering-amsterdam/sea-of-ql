package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.Expression;

public class Div extends BinaryExpr {
	
	public Div(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
}
