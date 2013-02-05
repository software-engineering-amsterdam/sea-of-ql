package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ast.VariableScope;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.Value;

public class IdentifierNode extends ExprNode
{
	public final String value;
	public final VariableScope variableScope;

	public IdentifierNode(final String value, final VariableScope variableScope)
	{
		this.value = value;
        this.variableScope = variableScope;
	}

    public IdentifierNode(final String value)
    {
        this.value = value;
        this.variableScope = new VariableScope();
    }

    @Override
    public Value evaluate()
    {
        final Value value = this.variableScope.resolve(this.value);
        if(value == null)
        {
            throw new RuntimeException("No such variable: " +this.value);
        }

        return value;
    }

    @Override
    public String toTreeString(String indent)
    {
        return '\n' + indent + this.value + " = " + String.valueOf(evaluate());
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

        IdentifierNode that = (IdentifierNode) o;
        return !(value != null ? !value.equals(that.value) : that.value != null);
    }

    @Override
    public int hashCode()
    {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return this.value;
    }
}
