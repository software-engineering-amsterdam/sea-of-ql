package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;

public abstract class ExprNode implements Node
{
    public abstract Value evaluate();
    public abstract Type getType();
    public abstract boolean validate(Collection<Message> messages);
    public abstract <T> T accept(ExpressionVisitor<T> expressionVisitor);
}
