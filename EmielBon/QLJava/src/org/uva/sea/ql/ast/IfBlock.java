package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.StatementVisitor;

public class IfBlock extends Statement {

	public final Expression expression;
	public final Statements statements;
	
	public IfBlock(Expression expression, Statements statements) {
		this.statements = statements;
		this.expression = expression;
	}

	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
