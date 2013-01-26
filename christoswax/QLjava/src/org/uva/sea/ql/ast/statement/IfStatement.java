package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.*;

public class IfStatement extends Statement {
	private final Expr condition;
	private final StatementsBlock block;

	public IfStatement(Expr condition, StatementsBlock block) {
		this.condition = condition;
		this.block = block ;
	}

	public Expr getCondition() {
		return condition;
	}

	public StatementsBlock getStatements() {
		return block;
	}
}
