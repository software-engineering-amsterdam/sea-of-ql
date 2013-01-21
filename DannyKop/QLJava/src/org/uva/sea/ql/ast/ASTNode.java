package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.Visitor;

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
	void accept(Visitor visitor);
}
