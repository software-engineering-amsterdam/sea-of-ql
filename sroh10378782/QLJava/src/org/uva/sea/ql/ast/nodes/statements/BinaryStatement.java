package org.uva.sea.ql.ast.nodes.statements;

import org.uva.sea.ql.ast.nodes.BinaryNode;

public abstract class BinaryStatement<T, E> extends Statement implements BinaryNode<T, E> {
	private final T lhs;
	private final E rhs;
	private final boolean isBinaryNode = true;
	private final boolean isUnaryNode = false;
	private final boolean isMultiNode = false;
	
	public BinaryStatement(T lhs, E rhs){
		this.lhs = lhs;
		this.rhs  = rhs;
	}

	@Override
	public T getLhs() {
		return this.lhs;
	}

	@Override
	public E getRhs() {
		return this.rhs;
	}

	@Override
	public boolean isBinaryNode() {
		return this.isBinaryNode;
	}

	@Override
	public boolean isUnaryNode() {
		return this.isUnaryNode;
	}

	@Override
	public boolean isMultiNode() {
		return this.isMultiNode;
	}
}