package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.visitor.gui.IFormVisitor;

public interface Statement {
	public <T> T accept(IFormVisitor<T> v);
}
