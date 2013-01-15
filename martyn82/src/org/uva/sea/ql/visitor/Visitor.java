package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ASTNode;

/**
 * Visitor for printing AST.
 */
abstract public class Visitor {
	/**
	 * Visits the given expression object.
	 * 
	 * @param expression The expression to visit.
	 */
	abstract public void visit( ASTNode expression );
}
