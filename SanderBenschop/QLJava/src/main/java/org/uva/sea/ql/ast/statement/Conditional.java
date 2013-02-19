package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;

import java.util.Collections;
import java.util.List;

public abstract class Conditional extends Statement {

    private final Expression condition;
    private final List<Statement> successBlock;

    public Conditional(Expression condition, List<Statement> successBlock) {
        this.condition = condition;
        this.successBlock = Collections.unmodifiableList(successBlock);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getSuccessBlock() {
        return successBlock;
    }
}
