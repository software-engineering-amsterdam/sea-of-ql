package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.SourceCodeInformation;

public abstract class UnaryOperation extends QLExpression {

    private final QLExpression expression;

    public UnaryOperation(QLExpression expression, SourceCodeInformation sourceInfo) {
        super(sourceInfo);
        this.expression = expression;
    }

    public QLExpression getExpression() {
        return expression;
    }
}
