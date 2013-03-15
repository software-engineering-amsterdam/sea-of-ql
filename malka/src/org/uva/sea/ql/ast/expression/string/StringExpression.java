package org.uva.sea.ql.ast.expression.string;

import org.uva.sea.ql.ast.expression.Expression;

public interface StringExpression extends Expression {
	String evaluate();
}
