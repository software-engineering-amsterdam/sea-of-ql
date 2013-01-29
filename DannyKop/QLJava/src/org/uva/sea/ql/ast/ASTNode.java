package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.*;

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
	public void accept(Visitor visitor);
}
