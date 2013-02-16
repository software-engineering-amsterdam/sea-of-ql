package org.uva.sea.ql.ast;

public class IfBlock extends Statement {

	public final Expression expression;
	public final Statements statements;
	
	public IfBlock(Expression expression, Statements statements) {
		this.statements = statements;
		this.expression = expression;
	}

}
