package org.uva.sea.ql.ast.expressions.visitor;


public interface Visitable {
	public <T> T accept(Visitor<T> visitor);
}
