package org.uva.sea.ql.ast.expression.bool;

import org.uva.sea.ql.ast.expression.Expression;

public interface BooleanExpression extends Expression {
	
	boolean evaluate();
	
}
