package org.uva.sea.ql.ast.expression.binary.bool;

import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.BooleanExpression;
import org.uva.sea.ql.ast.expression.Expression;

public class Or extends BinaryExpr implements BooleanExpression {
	
	public Or(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
}
