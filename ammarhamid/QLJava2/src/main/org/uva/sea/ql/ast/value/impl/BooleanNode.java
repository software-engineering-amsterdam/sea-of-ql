package org.uva.sea.ql.ast.value.impl;

import org.uva.sea.ql.ast.value.ValueNode;

public class BooleanNode extends ValueNode<Boolean> implements Comparable<BooleanNode>
{
    private final Boolean value;

    public BooleanNode(final Boolean value)
    {
        this.value = value;
    }

    public BooleanNode(final String value)
    {
        this.value = Boolean.valueOf(value);
    }

    @Override
    public Boolean getValue()
    {
        return this.value;
    }

    @Override
    public ValueNode evaluate()
    {
        return this;
    }

    @Override
    public int compareTo(BooleanNode o)
    {
        return this.value.compareTo(o.getValue());
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(o == null || getClass() != o.getClass())
        {
            return false;
        }

        BooleanNode that = (BooleanNode) o;
        return !(value != null ? !value.equals(that.value) : that.value != null);
    }

    @Override
    public int hashCode()
    {
        return value != null ? value.hashCode() : 0;
    }
}
