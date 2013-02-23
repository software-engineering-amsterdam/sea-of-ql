package org.uva.sea.ql.ast.expression.impl;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.UnaryNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.impl.NumericType;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public class NegateNode extends UnaryNode
{

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
    public Type getType()
    {
        return new NumericType();
    }

    @Override
    public boolean validate(final Collection<Message> errors)
    {
        final Type type = this.exprNode.getType();
        final boolean compatible = type.isCompatibleToNumeric();

        if(!compatible)
        {
            errors.add(createErrorMessage());
        }

        return compatible;
    }

    @Override
    protected String getOperator()
    {
        return "-";
    }

}
