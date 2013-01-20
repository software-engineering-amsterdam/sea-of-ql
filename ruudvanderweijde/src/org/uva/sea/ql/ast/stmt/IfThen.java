package org.uva.sea.ql.ast.stmt;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;

public class IfThen extends Statement {

	private final Expr condition;
	private final List<Statement> ifBlock;
	
	public IfThen(Expr condition, List<Statement> ifBlock) {
		this.condition = condition;
		this.ifBlock = ifBlock;
	}

	public Expr getCondition() {
		return condition;
	}

	public List<Statement> getIfBlock() {
		return ifBlock;
	}

}
