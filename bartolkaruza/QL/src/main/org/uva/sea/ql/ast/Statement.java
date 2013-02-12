package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.StatementVisitor;

public interface Statement extends ASTNode {
	
	public void accept(StatementVisitor<?> visitor);

}
