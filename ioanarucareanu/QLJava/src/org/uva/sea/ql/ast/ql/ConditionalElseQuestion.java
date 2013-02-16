package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.semanticchecker.StatementSemanticVisitor;

public class ConditionalElseQuestion extends ConditionalQuestion {
	
	private final Block elseStatements;

	public ConditionalElseQuestion(Expr condition,
			Block statements,
			Block elseStatements) {
		super(condition, statements);
		this.elseStatements = elseStatements;
	}

	public Block getElseStatements() {
		return elseStatements;
	}

	@Override
	public void accept(StatementSemanticVisitor visitor) {
		visitor.visit(this);		
	}
	
}
