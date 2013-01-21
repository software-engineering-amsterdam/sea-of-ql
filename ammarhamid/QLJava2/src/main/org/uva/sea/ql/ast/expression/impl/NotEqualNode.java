package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.ValueNode;
import org.uva.sea.ql.ast.value.impl.BooleanNode;

public class NotEqualNode extends ExprNode
{
    private final ExprNode lhs;
    private final ExprNode rhs;

    public NotEqualNode(final ExprNode lhs, final ExprNode rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public ValueNode evaluate()
    {
        final ValueNode valueNode1 = this.lhs.evaluate();
        final ValueNode valueNode2 = this.rhs.evaluate();

        return new BooleanNode(!valueNode1.getValue().equals(valueNode2.getValue()));
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + indent + "!=" + lhs.toTreeString(indent + "  ")
                + rhs.toTreeString(indent + "  ");
    }
}
