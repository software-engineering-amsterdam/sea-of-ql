package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

import java.util.Collections;
import java.util.List;

public abstract class Conditional implements QLStatement {

    private final QLExpression condition;
    private final List<QLStatement> successBlock;

    public Conditional(QLExpression condition, List<QLStatement> successBlock) {
        this.condition = condition;
        this.successBlock = Collections.unmodifiableList(successBlock);
    }

    public QLExpression getCondition() {
        return condition;
    }

    public List<QLStatement> getSuccessBlock() {
        return successBlock;
    }

    @Override
    public void accept(ASTNodeVisitor visitor) {
        condition.accept(visitor);

        for (QLStatement qlStatement : successBlock) {
            qlStatement.accept(visitor);
        }
    }
}
