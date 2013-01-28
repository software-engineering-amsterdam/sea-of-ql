package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.nodes.IBinaryNode;

public class GEq extends Expr implements IBinaryNode {
	private final Expr lhs;
	private final Expr rhs;
	
	public GEq(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs = rhs;
	}
	public Expr getLhs(){
		return this.lhs;
	}
	public Expr getRhs(){
		return this.rhs;
	}
	
	@Override
	public boolean isBinaryNode() {
		return true;
	}
	@Override
	public boolean isUnaryNode() {
		return false;
	}
	@Override
	public boolean isMultiNode() {
		return false;
	}
}
