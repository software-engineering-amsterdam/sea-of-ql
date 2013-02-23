package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public class UndefinedIdentifierNode extends IdentifierNode
{
    private final String identifier;
    private final Value defaultValue;

    public UndefinedIdentifierNode(String identifier, Value defaultValue)
    {
        super(identifier, defaultValue);
        this.identifier = identifier;
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean validate(Collection<Message> errors)
    {
        errors.add(new Message("Variable is undefined: ", this));
        return false;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> expressionVisitor)
    {
        return throwUnsupportedOperationException();
    }

    @Override
    public Value evaluate()
    {
        return throwUnsupportedOperationException();
    }

    @Override
    public Type getType()
    {
        return this.defaultValue.getType();
    }

    private <T> T throwUnsupportedOperationException()
    {
        throw new UnsupportedOperationException("Unsupported operation: " +this);
    }
}
