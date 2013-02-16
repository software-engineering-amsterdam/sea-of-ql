package org.uva.sea.ql.common;

public interface ASTElement {
	public void accept(ElementVisitor visitor) throws VisitorException;
}
