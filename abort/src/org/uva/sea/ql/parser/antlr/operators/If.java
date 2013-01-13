package org.uva.sea.ql.parser.antlr.operators;

import java.util.List;

import org.uva.sea.ql.ast.Expression;

public class If extends IfExpression {
	private Expression statement = null;
	private List<FormExpression> successStatements = null;
	
	public If(Expression statement, List<FormExpression> successStatements) {
		this.statement = statement;
		this.successStatements = successStatements;		
	}
}
