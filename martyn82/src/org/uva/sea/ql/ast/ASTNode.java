package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a node in an AST.
 */
public interface ASTNode {
	/**
	 * Accepts a visitor.
	 * 
	 * @param visitor The visitor.
	 * 
	 * @return The value the expression produces.
	 */
	void accept( Visitor visitor );
}
