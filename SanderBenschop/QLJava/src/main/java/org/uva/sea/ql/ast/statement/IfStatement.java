package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;

import java.util.List;

public class IfStatement extends Conditional {

    public IfStatement(Expression condition, List<Statement> successBlock) {
        super(condition, successBlock);
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitIfStatement(this);
    }
}
