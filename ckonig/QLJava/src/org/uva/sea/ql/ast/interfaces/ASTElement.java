package org.uva.sea.ql.ast.interfaces;

import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.common.interfaces.ElementVisitor;

public interface ASTElement {
	public void accept(ElementVisitor visitor) throws VisitorException;
}
