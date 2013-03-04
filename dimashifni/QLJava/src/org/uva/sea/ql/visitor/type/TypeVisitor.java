package org.uva.sea.ql.visitor.type;

import org.uva.sea.ql.type.*;

public interface TypeVisitor<T> {
    T visit(IntType type);
    T visit(MoneyType type);
    T visit(NumericType type);
    T visit(BoolType type);
    T visit(StringType type);
}
