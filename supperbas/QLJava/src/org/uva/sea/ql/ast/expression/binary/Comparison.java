package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.expression.Binary;



public abstract class Comparison extends Binary {
	
	public Comparison(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
}
