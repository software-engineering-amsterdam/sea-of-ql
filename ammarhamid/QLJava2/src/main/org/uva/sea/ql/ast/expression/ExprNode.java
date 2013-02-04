package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.value.Value;

public abstract class ExprNode implements Node
{
    public abstract Value evaluate();
}
