package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.ASTNodeVisitor;

import java.util.Collections;
import java.util.List;

public class IfElseStatement extends Conditional {

    private final List<QLStatement> failureBlock;

    public IfElseStatement(QLExpression condition, List<QLStatement> successBlock, List<QLStatement> failureBlock) {
        super(condition, successBlock);
        this.failureBlock = Collections.unmodifiableList(failureBlock);
    }

    public List<QLStatement> getFailureBlock() {
        return failureBlock;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitIfElseStatement(this);
    }
}
