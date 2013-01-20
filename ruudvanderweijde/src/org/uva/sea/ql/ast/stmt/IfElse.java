package org.uva.sea.ql.ast.stmt;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;

public class IfElse extends Statement {

	private final Expr condition;
	private final List<Statement> ifBlock;
	private final List<Statement> elseBlock;
	
	public IfElse(Expr condition, List<Statement> ifBlock,
			List<Statement> elseBlock) {
		this.condition = condition;
		this.ifBlock = ifBlock;
		this.elseBlock = elseBlock;
	}

	public Expr getCondition() {
		return condition;
	}

	public List<Statement> getIfBlock() {
		return ifBlock;
	}

	public List<Statement> getElseBlock() {
		return elseBlock;
	}

}
