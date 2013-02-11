package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.ast.value.impl.BooleanValue;

public class EqualNode extends ExprNode
{
    private final ExprNode lhs;
    private final ExprNode rhs;

    public EqualNode(final ExprNode lhs, final ExprNode rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Value evaluate()
    {
        final Value value1 = this.lhs.evaluate();
        final Value value2 = this.rhs.evaluate();

        return new BooleanValue(value1.evaluate().equals(value2.evaluate()));
    }

    @Override
    public String toTreeString(final String indent)
    {
        return '\n' + indent + "==" + lhs.toTreeString(indent + "  ")
                + rhs.toTreeString(indent + "  ");

    }
}
