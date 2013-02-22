package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.ErrorMessage;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.UnaryNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.NumericType;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public class NegateNode extends UnaryNode
{
    private static final String OPERATOR = "-";

    public NegateNode(final ExprNode exprNode)
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
        return value.negate();
    }

    @Override
    public boolean validate(final Collection<ErrorMessage> errors)
    {
        final Type type = this.exprNode.evaluate().getType();
        final boolean compatible = type.isCompatibleTo(new NumericType());

        if(!compatible)
        {
            errors.add(new ErrorMessage(this, "Invalid type for " + OPERATOR));
        }

        return compatible;
    }

    @Override
    public String toString()
    {
        return  OPERATOR + exprNode.toString();
    }

}
