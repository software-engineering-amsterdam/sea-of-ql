package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IBinaryNode;

public class ConditionalStatement extends Expr implements IBinaryNode {
	private final Expr condition;
	private final Expr block;
	
	public ConditionalStatement(Expr lhs, Expr rhs){
		this.condition = lhs;
		this.block = rhs;
	}
	
	public Expr getLhs(){
		return this.condition;
	}
	public Expr getRhs(){
		return this.block;
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
