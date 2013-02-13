package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;

public interface TypeVisitor<T> {
	T visit( BooleanType node );
	T visit( IntegerType node );
	T visit( StringType node );
	T visit( MoneyType node );
}
