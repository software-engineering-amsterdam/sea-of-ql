package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.ASTNodeVisitor;

import java.util.List;

public class IfStatement extends Conditional {

    public IfStatement(QLExpression condition, List<QLStatement> successBlock) {
        super(condition, successBlock);
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitIfStatement(this);
    }
}
