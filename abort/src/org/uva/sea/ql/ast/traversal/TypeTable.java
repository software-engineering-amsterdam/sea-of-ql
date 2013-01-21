package org.uva.sea.ql.ast.traversal;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.base.Node;

/**
 * Stores nodes and their expected result types.
 * @author J. Dijkstra
 */
abstract class TypeTable {
	/**
	 * Map that stores node types and their expected result types
	 */
	protected Map<Node, Class<? extends Node>> types = new HashMap<Node, Class<? extends Node>>();
	
	/**
	 * Constructor that limits access to the package scope.
	 */
	protected TypeTable() {	}

	/**
	 * Add result type for a node or operation
	 * @param node node/operation
	 * @param type result type
	 */
	public void addTypeForNode(final Node node, final Class<? extends Node> type) {
		types.put(node, type);
	}

	/**
	 * Retrieve the result type of a node or operation
	 * @param node node/operation
	 * @return result type for the node/operation
	 */
	public Class<? extends Node> getTypeOfNode(final Node node) {
		final Class<? extends Node> type = types.get(node);
		
		// Type is invalid or not yet resolved
		return type;
	}
}
