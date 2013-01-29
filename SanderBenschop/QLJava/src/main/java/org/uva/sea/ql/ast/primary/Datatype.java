package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.QLExpression;

public abstract class Datatype<T> implements QLExpression {

    public abstract T getValue();
}
