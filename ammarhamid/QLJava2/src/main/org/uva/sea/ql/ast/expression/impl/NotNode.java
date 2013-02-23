package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.UnaryNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public class NotNode extends UnaryNode
{
    private static final String OPERATOR = "!";

    public NotNode(final ExprNode exprNode)
    {
        super(exprNode);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> expressionVisitor)
    {
        return expressionVisitor.visit(this);
    }

    @Override
    public Value evaluate()
    {
        final Value value = this.exprNode.evaluate();
        return value.not();
    }

    @Override
    public Type getType()
    {
        return new BooleanType();
    }

    @Override
    public boolean validate(final Collection<Message> errors)
    {
        final Type type = this.exprNode.getType();
        final boolean compatible = type.isCompatibleToBoolean();

        if(!compatible)
        {
            errors.add(new Message("Invalid type for " + OPERATOR, this));
        }

        return compatible;
    }

    @Override
    public String toString()
    {
        return  OPERATOR + exprNode.toString();
    }
}
