package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expr;

public class ifElseStatement extends ifStatement {
	private final BlockOfStatements elseStms;
	
	public ifElseStatement(Expr condition, BlockOfStatements ifStms, BlockOfStatements elseStms) {
		super(condition, ifStms);
		this.elseStms = elseStms;
	}
	
	public BlockOfStatements getElseStms() {
		return elseStms;
	}
}