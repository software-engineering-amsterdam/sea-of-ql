package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.value.impl.UndefinedValue;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public class ValueNode extends ExprNode
{
    private final Value value;

    public ValueNode(final Value value)
    {
        this.value = value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> expressionVisitor)
    {
        return expressionVisitor.visit(this);
    }

    @Override
    public Value evaluate()
    {
        return this.value;
    }

    @Override
    public Type getType()
    {
        return this.value.getType();
    }

    @Override
    public boolean validate(Collection<Message> errors)
    {
        final boolean validate = !this.value.equals(new UndefinedValue());
        if(!validate)
        {
            throw new UnsupportedOperationException("Undefined default value: " + this);
        }

        return validate;
    }

    @Override
    public String toString()
    {
        return value.toString();
    }
}
