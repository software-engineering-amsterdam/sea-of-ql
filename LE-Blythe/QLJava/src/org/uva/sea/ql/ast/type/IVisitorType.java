package org.uva.sea.ql.ast.type;


public interface IVisitorType<T> {

	T visit(BoolType b);
	T visit(IntType n);
	T visit(StrType s);
	T visit(UndefinedType u);
	T visit(NumericType n);
	
}
