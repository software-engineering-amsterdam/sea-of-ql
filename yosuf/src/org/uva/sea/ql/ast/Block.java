package org.uva.sea.ql.ast;


/**
 * A block is a combination of single or multipe lines.
 */
public abstract class Block implements ASTNode {

	protected Block() {
		super();
	}

	public abstract <T> T accept(StatementVisitor<T> visitor);
}
