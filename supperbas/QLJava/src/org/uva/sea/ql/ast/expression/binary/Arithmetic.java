package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.expression.Binary;



public abstract class Arithmetic extends Binary {
	
	public Arithmetic(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
}
