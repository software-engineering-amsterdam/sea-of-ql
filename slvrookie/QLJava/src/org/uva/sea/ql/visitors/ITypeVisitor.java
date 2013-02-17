package org.uva.sea.ql.visitors;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;

public interface ITypeVisitor<T> {
	
	T visit (BoolType node);
	T visit (IntType node);
	T visit (MoneyType node);
	T visit (StringType node);

}
