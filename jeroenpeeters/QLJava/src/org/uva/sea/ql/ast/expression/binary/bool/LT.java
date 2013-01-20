package org.uva.sea.ql.ast.expression.binary.bool;

import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.Expression;

public class LT extends BinaryExpr {
	
	public LT(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
}
