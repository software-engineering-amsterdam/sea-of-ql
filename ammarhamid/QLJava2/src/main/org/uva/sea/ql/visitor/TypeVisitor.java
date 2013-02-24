package org.uva.sea.ql.visitor;

import org.uva.sea.ql.type.impl.BooleanType;
import org.uva.sea.ql.type.impl.IntegerType;
import org.uva.sea.ql.type.impl.MoneyType;
import org.uva.sea.ql.type.impl.StringType;

public interface TypeVisitor<T>
{
    T visit(BooleanType booleanType);

    T visit(StringType stringType);

    T visit(IntegerType integerType);

    T visit(MoneyType moneyType);
}
