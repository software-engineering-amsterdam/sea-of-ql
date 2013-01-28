package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.types.TypeDescription;

public interface  ExpressionResult {
	String toString() ;
	int getValue();
	abstract public TypeDescription typeOf() ;
}
