package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.expression.Binary;



public abstract class Logic extends Binary {
	
	public Logic(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
}
