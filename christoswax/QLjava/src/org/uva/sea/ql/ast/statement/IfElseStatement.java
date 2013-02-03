package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.*;

/* TODO: make this extend IfStatement */

public class IfElseStatement extends Statement {
	private final Expr condition;
	private final StatementsBlock blockIf;
	private final StatementsBlock blockElse;

	public IfElseStatement(Expr condition, StatementsBlock blockIf, StatementsBlock blockElse) {
		this.condition = condition;
		this.blockIf = blockIf;
		this.blockElse = blockElse;
	}

	public Expr getCondition() {
		return condition;
	}

	public StatementsBlock getIfStatements() {
		return blockIf;
	}
	public StatementsBlock getElseStatements() {
		return blockElse;
	}
}
