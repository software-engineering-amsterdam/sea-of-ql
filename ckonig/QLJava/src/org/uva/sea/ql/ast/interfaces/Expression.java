package org.uva.sea.ql.ast.interfaces;

import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public interface Expression {
    public void accept(ExpressionVisitor visitor) throws QLException;
}