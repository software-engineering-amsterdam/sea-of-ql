package org.uva.sea.ql.ast.traversal.logging;

import org.uva.sea.ql.ast.base.Node;

/**
 * Type checking event log.
 * 
 * @author J. Dijkstra
 */
public class TypeEventLog extends Log {
	/**
	 * Add correct semantics event to the log.
	 * 
	 * @param node
	 *            node to add the correct semantics event about
	 */
	public void addCorrectSemantics(final Node node) {
		add(new TypeMessage(node, "Correct semantics and types identified"));
	}
}
