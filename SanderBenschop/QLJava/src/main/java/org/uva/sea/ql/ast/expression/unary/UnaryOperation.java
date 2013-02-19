package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.SourceCodeInformation;

public abstract class UnaryOperation extends Expression {

    private final Expression expression;

    public UnaryOperation(Expression expression, SourceCodeInformation sourceInfo) {
        super(sourceInfo);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
