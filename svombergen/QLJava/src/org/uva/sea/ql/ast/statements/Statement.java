package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.visitor.IFormVisitor;

public interface Statement {
	public void accept(IFormVisitor v);
}
