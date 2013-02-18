package org.uva.sea.ql.ast.nodes;

public interface NodeType {
	public boolean isBinaryNode();
	public boolean isUnaryNode();
	public boolean isMultiNode();
}
