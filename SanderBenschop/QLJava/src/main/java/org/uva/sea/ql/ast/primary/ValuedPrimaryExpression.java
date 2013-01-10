package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.QLExpression;

public abstract class ValuedPrimaryExpression<T> extends QLExpression {

	public abstract T getValue();
}
