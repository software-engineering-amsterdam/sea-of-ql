package org.uva.sea.ql.ast.visitor;

public interface Visitable {
	<T> T accept(Visitor<T> visitor) ;
}


