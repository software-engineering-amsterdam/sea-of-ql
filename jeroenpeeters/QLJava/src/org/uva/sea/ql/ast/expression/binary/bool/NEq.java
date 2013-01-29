package org.uva.sea.ql.ast.expression.binary.bool;

import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.BooleanExpression;
import org.uva.sea.ql.ast.expression.Expression;

public class NEq extends BinaryExpr implements BooleanExpression {
	
	public NEq(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
}
