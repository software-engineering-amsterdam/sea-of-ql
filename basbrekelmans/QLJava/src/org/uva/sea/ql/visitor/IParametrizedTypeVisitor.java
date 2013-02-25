package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.UnknownType;

public interface IParametrizedTypeVisitor<TParameter, TResult> {
	TResult visit(BooleanType element, TParameter arg);

	TResult visit(IntegerType element, TParameter arg);

	TResult visit(MoneyType element, TParameter arg);

	TResult visit(StringType element, TParameter arg);

	TResult visit(UnknownType element, TParameter arg);
}
