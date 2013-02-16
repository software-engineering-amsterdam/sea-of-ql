package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.semanticchecker.StatementSemanticVisitor;

public class ConditionalQuestion extends Statement {
	
	private final Expr condition;
	private final Block statements;
	
	public ConditionalQuestion(Expr condition, Block statements) {
		this.condition = condition;
		this.statements = statements;
	}

	public Expr getCondition() {
		return condition;
	}

	public Block getStatements() {
		return statements;
	}

	@Override
	public void accept(StatementSemanticVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean isDependent() {
		
		return true;
	}
	

}
