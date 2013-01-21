package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.value.impl.*;

public abstract class ValueNode<T> extends ExprNode
{

    public static final ValueNode VOID = new ValueNode()
    {
        @Override
        public Object getValue()
        {
            return this;
        }

        @Override
        public ValueNode evaluate()
        {
            return this;
        }
    };

	public abstract T getValue();

    public BooleanNode asBooleanNode()
    {
        return (BooleanNode) this;
    }

    public boolean isBooleanNode()
    {
        return this instanceof BooleanNode;
    }

    public IntegerNode asIntegerNode()
    {
        return (IntegerNode) this;
    }

    public boolean isIntegerNode()
    {
        return this instanceof IntegerNode;
    }

    public MoneyNode asMoneyNode()
    {
        return (MoneyNode) this;
    }

    public boolean isMoneyNode()
    {
        return this instanceof MoneyNode;
    }

    public StringNode asStringNode()
    {
        return (StringNode) this;
    }

    public boolean isStringNode()
    {
        return this instanceof StringNode;
    }

    public IdentifierNode asIdentifierNode()
    {
        return (IdentifierNode) this;
    }

    public boolean isIdentifierNode()
    {
        return this instanceof IdentifierNode;
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + indent + String.valueOf(getValue());
    }

    @Override
    public String toString()
    {
        return getValue().toString();
    }

}
