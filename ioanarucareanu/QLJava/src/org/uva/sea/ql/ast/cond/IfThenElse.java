package org.uva.sea.ql.ast.cond;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.Expr;

public class IfThenElse extends IfThen {
	
	private final Block<? extends Statement> elseStatements;

	public IfThenElse(Expr condition, Block<? extends Statement> statements, Block<? extends Statement> elseStatements) {
		super(condition, statements);
		this.elseStatements = elseStatements;
	}

	public Block<? extends Statement> getElseStatements() {
		return elseStatements;
	}

}
