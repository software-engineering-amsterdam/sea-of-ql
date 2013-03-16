package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;

public class IfStatement extends Statement {

	private final Expression expression;
	private final Statement statement;
	
	public IfStatement(Expression expr, Statement statement) {
		this.expression = expr;
		this.statement = statement;
	}
	
	public Expression getExpression() {
		return expression;
	}

	public Statement getStatement() {
		return statement;
	}

	public <T> T accept(final StatementVisitor<T> v){
		return v.visit(this);
	}
	
}