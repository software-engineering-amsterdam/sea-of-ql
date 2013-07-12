package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.visitor.IFormVisitor;

public interface Statement {
	public <T> T accept(IFormVisitor<T> v);
}
