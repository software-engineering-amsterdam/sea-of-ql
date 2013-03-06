package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.StringType;

public interface TypeVisitor<T> {

	T visit(BooleanType booleanDeclaration);
	T visit(IntegerType intDeclaration);
	T visit(StringType stringDeclaration);
}
