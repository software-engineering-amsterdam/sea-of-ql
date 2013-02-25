package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.UnknownType;

public interface ITypeVisitor<T> {
	T visit(BooleanType element);

	T visit(IntegerType element);

	T visit(MoneyType element);

	T visit(StringType element);

	T visit(UnknownType element);
}
