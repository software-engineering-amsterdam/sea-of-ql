package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.nodes.UnaryNode;

public class UnaryExpr extends Expr implements UnaryNode<Expr>{
	private final String operator = "";
	private final Expr primary;
	private final boolean isBinaryNode = false;
	private final boolean isUnaryNode = true;
	private final boolean isMultiNode = false;
	
	public UnaryExpr(Expr primary){
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
	public String getOperator(){
		return this.operator;
	}
}
