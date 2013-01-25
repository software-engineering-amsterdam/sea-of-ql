package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IBinaryNode;

public class QuestionBody extends Expr implements IBinaryNode {
	private final Expr lhs;
	private final Expr rhs;
	
	public QuestionBody(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs = rhs;
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
