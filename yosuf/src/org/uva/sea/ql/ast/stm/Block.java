package org.uva.sea.ql.ast.stm;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.StatementVisitor;

/**
 * A block represents single or multiple lines.
 */
public abstract class Block implements ASTNode {

	protected Block() {
		super();
	}

	public abstract <T> T accept(StatementVisitor<T> visitor);
}
