package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.ValueNode;
import org.uva.sea.ql.ast.value.impl.IntegerNode;
import org.uva.sea.ql.ast.value.impl.MoneyNode;
import org.uva.sea.ql.ast.value.impl.StringNode;

public class AddNode extends ExprNode
{
    private final ExprNode lhs;
    private final ExprNode rhs;

    public AddNode(final ExprNode lhs, final ExprNode rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public ValueNode evaluate()
    {
        final ValueNode valueNode1 = this.lhs.evaluate();
        final ValueNode valueNode2 = this.rhs.evaluate();

        final ValueNode result;
        if(valueNode1.isStringNode() || valueNode2.isStringNode())
        {
            result = new StringNode(valueNode1.getValue() + "" + valueNode2.getValue());
        }
        else if(valueNode1.isIntegerNode() && valueNode2.isIntegerNode())
        {
            final IntegerNode integerNode1 = valueNode1.asIntegerNode();
            final IntegerNode integerNode2 = valueNode2.asIntegerNode();
            result = new IntegerNode(integerNode1.getValue() + integerNode2.getValue());
        }
        else if(valueNode1.isMoneyNode() && valueNode2.isMoneyNode())
        {
            final MoneyNode moneyNode1 = valueNode1.asMoneyNode();
            final MoneyNode moneyNode2 = valueNode2.asMoneyNode();
            result = new MoneyNode(moneyNode1.getValue().add(moneyNode2.getValue()));
        }
        else
        {
            throw new InvalidTypeException("Invalid operand type for add(+) operation: " + toTreeString(" "));
        }

        return result;
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + indent + "+" + lhs.toTreeString(indent + "  ")
                + rhs.toTreeString(indent + "  ");
    }

}
