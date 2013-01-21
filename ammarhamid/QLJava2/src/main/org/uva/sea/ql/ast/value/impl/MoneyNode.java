package org.uva.sea.ql.ast.value.impl;

import org.uva.sea.ql.ast.value.ValueNode;

import java.math.BigDecimal;

/**
 * Money value
 * <p/>
 * Author: ammar.hamid
 * Date: 1/20/13 10:13 AM
 */
public class MoneyNode extends ValueNode<BigDecimal> implements Comparable<MoneyNode>
{
    private final BigDecimal value;

    public MoneyNode(final String value)
    {
        this.value = new BigDecimal(value);
    }

    public MoneyNode(final BigDecimal value)
    {
        this.value = value;
    }

    @Override
    public BigDecimal getValue()
    {
        return this.value;
    }

    @Override
    public ValueNode evaluate()
    {
        return this;
    }

    @Override
    public int compareTo(MoneyNode o)
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

        MoneyNode that = (MoneyNode) o;
        return !(value != null ? !value.equals(that.value) : that.value != null);
    }

    @Override
    public int hashCode()
    {
        return value != null ? value.hashCode() : 0;
    }
}
