package org.uva.sea.ql.ast.statements.visitor;

public interface Visitable {
	public void accept(Visitor visitor);
}