package org.uva.sea.ql.ast.type;

public interface DataTypeVisitor<T> {

	T visit(BooleanType booleanType);

	T visit(IntegerType integerType);

	T visit(MoneyType moneyType);

	T visit(StringType stringType);
}
