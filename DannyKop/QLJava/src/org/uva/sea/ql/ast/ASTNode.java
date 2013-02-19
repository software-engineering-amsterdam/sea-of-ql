package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.Visitor;

/**
 * Interface: ASTNode
 * @author Danny
 *
 */
public interface ASTNode {
	/**
	 * accept()
	 * @param visitor
	 */
	public <T> T accept(Visitor<T> visitor);
}
