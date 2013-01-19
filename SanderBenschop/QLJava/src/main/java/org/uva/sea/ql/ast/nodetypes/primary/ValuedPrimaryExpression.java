package org.uva.sea.ql.ast.nodetypes.primary;

public abstract class ValuedPrimaryExpression<T> extends Primary {

	public abstract T getValue();
}
