package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

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
    public void accept(ASTNodeVisitor visitor) {
        super.accept(visitor);

        for(QLStatement qlStatement : failureBlock) {
            qlStatement.accept(visitor);
        }

        visitor.visitConditional(this);
    }
}
