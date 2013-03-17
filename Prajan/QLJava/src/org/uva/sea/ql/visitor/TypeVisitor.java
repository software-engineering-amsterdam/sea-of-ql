package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.gen.TypeError;

public interface TypeVisitor<T> {

	T visit(BoolType type);

	T visit(StrType type);

	T visit(MoneyType type);

	T visit(IntType type);

	T visit(NumericType type);

	T visit(TypeError type);

}
