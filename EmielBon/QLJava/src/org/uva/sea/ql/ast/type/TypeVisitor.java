package org.uva.sea.ql.ast.type;

public interface TypeVisitor<T> {

	T visit(Bool type);
	T visit(ErrorType type);
	T visit(Int type);
	T visit(Numeric type);
	T visit(Str type);
	
}
