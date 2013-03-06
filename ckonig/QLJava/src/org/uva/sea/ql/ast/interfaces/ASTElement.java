package org.uva.sea.ql.ast.interfaces;

import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.QLException;

public interface ASTElement {
	public void accept(ElementVisitor visitor) throws QLException;
}
