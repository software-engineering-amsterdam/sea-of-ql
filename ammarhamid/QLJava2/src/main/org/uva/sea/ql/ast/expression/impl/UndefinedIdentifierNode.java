package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.UndefinedType;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.value.impl.UndefinedValue;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;
import java.util.Map;

public class UndefinedIdentifierNode extends IdentifierNode
{

    public UndefinedIdentifierNode(String identifier)
    {
        super(identifier, new UndefinedValue());
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
    public Value evaluate(final Map<IdentifierNode, Value> variables)
    {
        return throwUnsupportedOperationException();
    }

    @Override
    public Type getType()
    {
        return new UndefinedType();
    }

    private <T> T throwUnsupportedOperationException()
    {
        throw new UnsupportedOperationException("Unsupported operation: " +this);
    }
}
