package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ErrorMessage;
import org.uva.sea.ql.VariableScope;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;

import java.util.Collection;

public class IdentifierNode extends ExprNode
{
    public final String identifier;
    public final VariableScope variableScope;

    public IdentifierNode(final String identifier, final VariableScope variableScope)
    {
        this.identifier = identifier;
        this.variableScope = variableScope;
    }

    public IdentifierNode(final String identifier)
    {
        this.identifier = identifier;
        this.variableScope = new VariableScope();
    }

    @Override
    public Value evaluate()
    {
        return this.variableScope.resolve(this.identifier);
    }

    @Override
    public boolean validate(Collection<ErrorMessage> errorMessages)
    {
        final Value value = this.variableScope.resolve(this.identifier);
        if(value == null)
        {
            errorMessages.add(new ErrorMessage(this, "Undefined variable: " + this.identifier));
        }

        return value != null;
    }

}
