package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;

public class IfElseStatement extends IfStatement {

	private final Statement elseStatement;
	
	public IfElseStatement(Expression expr, Statement statement, Statement elseStatement) {
		super(expr, statement);
		this.elseStatement = elseStatement;
	}

	public Statement getElseStatement() {
		return elseStatement;
	}
	
	public <T> T accept(final StatementVisitor<T> v){
		return v.visit(this);
	}
	
}