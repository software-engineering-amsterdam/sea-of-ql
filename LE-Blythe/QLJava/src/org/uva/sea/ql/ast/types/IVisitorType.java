package org.uva.sea.ql.ast.types;


public interface IVisitorType<T> {

	T visit(Bool b);
	T visit(Int n);
	T visit(Str s);
	T visit(Undefined u);
	T visit(Numeric n);
	
}
