package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ErrorMessage;
import org.uva.sea.ql.VariableState;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;

import java.util.Collection;

public class IdentifierNode extends ExprNode
{
    public final String identifier;

    public IdentifierNode(final String identifier)
    {
        this.identifier = identifier;
    }

    @Override
    public Value evaluate()
    {
        return VariableState.getVariableMap().get(this.identifier);
    }

    @Override
    public boolean validate(Collection<ErrorMessage> errorMessages)
    {
        final Value value = VariableState.getVariableMap().get(this.identifier);
        if(value == null)
        {
            errorMessages.add(new ErrorMessage(this, "Undefined variable: " + this.identifier));
        }

        return value != null;
    }

}
