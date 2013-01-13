package org.uva.sea.ql.parser.antlr.operators;

import org.uva.sea.ql.ast.Expression;

public class IfElse extends IfExpression {
	private Expression statement = null;
	private Expression successStatement = null;
	private Expression elseStatement = null;
	
	public IfElse(Expression statement, Expression successStatement, Expression elseStatement) {
		this.statement = statement;
		this.successStatement = successStatement;
		this.elseStatement = elseStatement;
	}
}
