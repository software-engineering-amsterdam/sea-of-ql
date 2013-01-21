package org.uva.sea.ql.ast.value.impl;

import org.uva.sea.ql.ast.value.ValueNode;

public class StringNode extends ValueNode<String> implements Comparable<StringNode>
{
	private final String value;
	
	public StringNode(final String value)
	{
		this.value = value;
	}

    @Override
    public String getValue()
    {
        return this.value;
    }

    @Override
    public ValueNode evaluate()
    {
        return this;
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + indent + this.value;
    }

    @Override
    public int compareTo(StringNode o)
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

        StringNode that = (StringNode) o;
        return !(value != null ? !value.equals(that.value) : that.value != null);
    }

    @Override
    public int hashCode()
    {
        return value != null ? value.hashCode() : 0;
    }
}
