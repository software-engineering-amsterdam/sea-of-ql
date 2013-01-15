package org.uva.sea.ql.ast.traversal;

import java.util.LinkedHashMap;
import java.util.Map;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.types.DataType;

class TypeContainer {
	// Store the return type for a node
	private Map<Node, Class<? extends Node>> resolvedTypes = new LinkedHashMap<Node, Class<? extends Node>>();
	
	public TypeContainer() {
		
	}
	
	public void addTypeForNode(final Node node, final Class<? extends Node> type) {
		resolvedTypes.put(node, type);
		// TODO: remove subnode values
	}
	
	public Class<? extends Node> getTypeOfNode(final Node node) {
		final Class<? extends Node> type = resolvedTypes.get(node);
		
		// Type is invalid or not yet resolved
		return type;
	}
}
