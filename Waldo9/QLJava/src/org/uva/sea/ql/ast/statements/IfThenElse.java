package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expr;

public class IfThenElse extends Statement {

	private Block body;
	private Block elseBody;
	private Expr condition;

	public IfThenElse(Expr condition, Block body, Block elseBody) {
		this.body = body;
		this.elseBody = elseBody;
		this.condition = condition;
	}
	
}
