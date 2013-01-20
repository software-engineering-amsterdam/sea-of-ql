package org.uva.sea.ql.visitor;

public interface ASTElement {
	public void accept(ASTVisitor visitor);
}
