package org.uva.sea.ql.parser.antlr.operators;

import java.util.List;

import org.uva.sea.ql.ast.Expression;

public class IfElse extends IfExpression {
	private Expression statement = null;
	private List<FormExpression> successStatements = null;
	private List<FormExpression> elseStatements = null;
	
	public IfElse(Expression statement, List<FormExpression> successStatements, List<FormExpression> elseStatements) {
		this.statement = statement;
		this.successStatements = successStatements;
		this.elseStatements = elseStatements;
	}
}
