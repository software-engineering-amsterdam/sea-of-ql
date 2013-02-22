package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ErrorMessage;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public abstract class ExprNode implements Node
{
    public abstract <T> T accept(ExpressionVisitor<T> expressionVisitor);
    public abstract Value evaluate();
    public abstract boolean validate(Collection<ErrorMessage> errorMessages);
}
