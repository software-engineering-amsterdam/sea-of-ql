package org.uva.sea.ql.ast.traversal;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.base.Node;

abstract class TypeContainer {
	// Store the type for a node
	protected Map<Node, Class<? extends Node>> types = new HashMap<Node, Class<? extends Node>>();
	
	protected TypeContainer() {
		
	}

	// TODO: might remove subnode values
	public void addTypeForNode(final Node node, final Class<? extends Node> type) {
		types.put(node, type);
	}
	

	public Class<? extends Node> getTypeOfNode(final Node node) {
		final Class<? extends Node> type = types.get(node);
		
		// Type is invalid or not yet resolved
		return type;
	}
}
