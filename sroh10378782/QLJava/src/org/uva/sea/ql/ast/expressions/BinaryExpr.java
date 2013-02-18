package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.nodes.BinaryNode;

public class BinaryExpr extends Expr implements BinaryNode<Expr, Expr>{
	private final Expr lhs;
	private final Expr rhs;
	private final String operator = "";
	private final boolean isBinaryNode = true;
	private final boolean isUnaryNode = false;
	private final boolean isMultiNode = false;
	
	public BinaryExpr(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs  = rhs;
	}

	@Override
	public Expr getLhs() {
		return this.lhs;
	}

	@Override
	public Expr getRhs() {
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
	public String getOperator(){
		return this.operator;
	}
}
