package org.uva.sea.ql.ast.value.impl;

import org.uva.sea.ql.ast.value.ValueNode;

public class IntegerNode extends ValueNode<Integer> implements Comparable<IntegerNode>
{
	private final Integer value;
	
	public IntegerNode(int value)
	{
		this.value = value;
	}

    public IntegerNode(String value)
    {
        this.value = Integer.valueOf(value);
    }

    @Override
    public Integer getValue()
    {
        return this.value;
    }

    @Override
    public ValueNode evaluate()
    {
        return this;
    }

    @Override
    public int compareTo(IntegerNode o)
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

        IntegerNode that = (IntegerNode) o;
        return !(value != null ? !value.equals(that.value) : that.value != null);
    }

    @Override
    public int hashCode()
    {
        return value != null ? value.hashCode() : 0;
    }
}

