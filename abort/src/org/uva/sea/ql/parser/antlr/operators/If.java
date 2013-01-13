package org.uva.sea.ql.parser.antlr.operators;

import org.uva.sea.ql.ast.Expression;

public class If extends IfExpression {
	private Expression statement = null;
	private Expression successStatement = null;
	
	public If(Expression statement, Expression successStatement) {
		this.statement = statement;
		this.successStatement = successStatement;		
	}
}
