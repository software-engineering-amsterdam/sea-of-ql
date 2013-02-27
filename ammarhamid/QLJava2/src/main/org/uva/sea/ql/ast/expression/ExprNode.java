package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

import java.util.Collection;
import java.util.Map;

public abstract class ExprNode implements Node
{
    public abstract Type getType();

    public abstract Value evaluate(Map<IdentifierNode, Value> variables);

    public abstract boolean validate(Collection<Message> errors);

    public abstract <T> T accept(ExpressionVisitor<T> expressionVisitor);
}
