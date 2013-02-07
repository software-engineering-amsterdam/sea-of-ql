package org.uva.sea.ql.ast.cond;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.Expr;

public class IfThen implements ASTNode{
	private final Expr condition;
	private final Block<? extends Statement> statements;
	
	public IfThen(Expr condition, Block<? extends Statement> statements) {
		super();
		this.condition = condition;
		this.statements = statements;
	}

	public Expr getCondition() {
		return condition;
	}

	public Block<? extends Statement> getStatements() {
		return statements;
	}
	
	
}
