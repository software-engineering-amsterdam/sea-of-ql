package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IBinaryNode;

public class Form extends Expr implements IBinaryNode {
	private final Expr lhs;
	private final Expr rhs;
	public Form(Expr ident, Expr blockContent){
		this.lhs = ident;
		this.rhs = blockContent;
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
