package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public class IdentifierNode extends ExprNode
{
    private final String identifier;
    private final Value defaultValue;

    public IdentifierNode(final String identifier, final Value defaultValue)
    {
        this.identifier = identifier;
        this.defaultValue = defaultValue;
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
    public boolean validate(Collection<Message> errors)
    {
        return true;
    }

    @Override
    public Type getType()
    {
        return this.defaultValue.getType();
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        IdentifierNode that = (IdentifierNode) o;
        return !(identifier != null ? !identifier.equals(that.identifier) : that.identifier != null);
    }

    @Override
    public int hashCode()
    {
        return identifier != null ? identifier.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return identifier;
    }
}
