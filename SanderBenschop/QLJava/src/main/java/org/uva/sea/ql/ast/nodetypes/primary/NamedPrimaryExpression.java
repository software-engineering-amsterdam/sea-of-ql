package org.uva.sea.ql.ast.nodetypes.primary;

import org.uva.sea.ql.ast.QLExpression;

public abstract class NamedPrimaryExpression extends QLExpression {

    public abstract String getName();
}
