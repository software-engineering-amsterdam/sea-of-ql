package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.types.*;

public interface ITypeVisitor<T> {
	
	T visit(BoolType type);
	T visit(IntType type);
	T visit(StringType type);
	T visit(ErrorType type);
}