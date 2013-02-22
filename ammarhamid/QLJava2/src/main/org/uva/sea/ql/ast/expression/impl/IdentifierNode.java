package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ErrorMessage;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public class IdentifierNode extends ExprNode
{
    public final String identifier;

    public IdentifierNode(final String identifier)
    {
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> expressionVisitor)
    {
        return expressionVisitor.visit(this);
    }

    @Override
    public Value evaluate()
    {
        return VariableState.getVariables().get(this);
    }

    @Override
    public boolean validate(Collection<ErrorMessage> errorMessages)
    {
        // TODO use contains key rather than check its value
        final Value value = VariableState.getVariables().get(this);
        if(value == null)
        {
            errorMessages.add(new ErrorMessage(this, "Undefined variable: " + this.identifier));
        }

        return value != null;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        IdentifierNode that = (IdentifierNode) o;

        if(identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return identifier != null ? identifier.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "IdentifierNode{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
