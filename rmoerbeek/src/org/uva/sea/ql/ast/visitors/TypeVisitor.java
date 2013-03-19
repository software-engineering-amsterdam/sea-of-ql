package org.uva.sea.ql.ast.visitors;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Error;

public interface TypeVisitor<T> {
	
	T visit(BooleanType type);
	T visit(IntType type);
	T visit(StringType type);
	T visit(Error type);

}
