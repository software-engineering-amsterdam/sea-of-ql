package org.uva.sea.ql.ast.nodes;

public interface UnaryNode<T> extends NodeType{
	public T getExpr();
}