package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Undefined;

public interface IVisitorType<T> {

	T visit(Bool b);
	T visit(Int n);
	T visit(Str s);
	T visit(Undefined u);
	T visit(Numeric n);
	
}
