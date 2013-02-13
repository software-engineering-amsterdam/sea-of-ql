package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;

public class ValueNode extends ExprNode
{
    private final Value value;

    public ValueNode(final Value value)
    {
        this.value = value;
    }

    @Override
    public Value evaluate()
    {
        return this.value;
    }
}
