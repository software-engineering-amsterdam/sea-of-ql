package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

import java.util.List;

public class IfStatement extends Conditional {

    public IfStatement(ASTNode condition, List<QLStatement> successBlock) {
        super(condition, successBlock);
    }

    @Override
    public void accept(ASTNodeVisitor visitor) {
        super.accept(visitor);
        visitor.visitConditional(this);
    }
}
