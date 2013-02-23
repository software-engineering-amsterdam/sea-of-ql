package org.uva.sea.ql.visitor;

import org.uva.sea.ql.type.impl.*;

public interface TypeVisitor
{
    void visit(BooleanType booleanType);

    void visit(StringType stringType);

    void visit(IntegerType integerType);

    void visit(MoneyType moneyType);
}
