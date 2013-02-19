package org.uva.sea.ql.ast.nodes.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.nodes.UnaryNode;

public abstract class UnaryStatement extends Statement implements UnaryNode<Expr>{
	private final Expr primary;
	private final boolean isBinaryNode = false;
	private final boolean isUnaryNode = true;
	private final boolean isMultiNode = false;
	
	public UnaryStatement(Expr primary){
		this.primary = primary;
	}
	
	@Override
	public Expr getExpr() {
		return this.primary;
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
