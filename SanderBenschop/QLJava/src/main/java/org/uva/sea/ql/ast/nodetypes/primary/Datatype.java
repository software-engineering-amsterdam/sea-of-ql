package org.uva.sea.ql.ast.nodetypes.primary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;

public abstract class Datatype<T> implements ASTNode {

    public abstract T getValue();

    @Override
    public void accept(ASTNodeVisitor visitor) {
        visitor.visitPrimary(this);
    }
}
