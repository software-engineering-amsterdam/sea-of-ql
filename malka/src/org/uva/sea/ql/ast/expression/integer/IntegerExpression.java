package org.uva.sea.ql.ast.expression.integer;

import org.uva.sea.ql.ast.expression.Expression;

public interface IntegerExpression extends Expression {
	public int evaluate();
}
