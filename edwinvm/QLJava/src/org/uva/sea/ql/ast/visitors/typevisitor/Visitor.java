package org.uva.sea.ql.ast.visitors.typevisitor;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Error;

public interface Visitor<T> {

	T visit(Bool    type);
	T visit(Int     type);
	T visit(Money   type);
	T visit(Numeric type);
	T visit(Str     type);
	T visit(Error   type);
	
}