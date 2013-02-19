package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;

import java.util.Collections;
import java.util.List;

public class IfElseStatement extends Conditional {

    private final List<Statement> failureBlock;

    public IfElseStatement(Expression condition, List<Statement> successBlock, List<Statement> failureBlock) {
        super(condition, successBlock);
        this.failureBlock = Collections.unmodifiableList(failureBlock);
    }

    public List<Statement> getFailureBlock() {
        return failureBlock;
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitIfElseStatement(this);
    }
}
