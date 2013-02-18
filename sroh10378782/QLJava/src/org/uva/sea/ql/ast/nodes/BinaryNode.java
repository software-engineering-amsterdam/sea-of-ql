package org.uva.sea.ql.ast.nodes;

public interface BinaryNode<T, E>{
	public T getLhs();
	public E getRhs();
	public boolean isBinaryNode();
	public boolean isUnaryNode();
	public boolean isMultiNode();
}
