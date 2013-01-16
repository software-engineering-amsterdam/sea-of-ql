package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Node;

/**
 * Visitor for printing AST.
 */
public interface Visitor {
	/**
	 * Dispatcher visit.
	 * 
	 * @param node
	 */
	void visit( Node node );
}
