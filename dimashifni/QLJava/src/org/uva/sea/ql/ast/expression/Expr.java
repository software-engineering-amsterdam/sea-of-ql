package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionVisitor;

import java.util.Map;

public abstract class Expr implements ASTNode {

    public abstract Value evaluate(Map<Ident, Value> variables);
    public abstract <T> T accept(ExpressionVisitor<T> visitor);
    public abstract Type getType();
}
