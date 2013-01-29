package org.uva.sea.ql.common;

public interface ASTElement {
	public void accept(ASTVisitor visitor) throws VisitorException;
}
