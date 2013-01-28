package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public abstract class Datatype<T> implements QLExpression {

    public abstract T getValue();

    @Override
    public void accept(ASTNodeVisitor visitor) {
        visitor.visitDatatype(this);
    }
}
