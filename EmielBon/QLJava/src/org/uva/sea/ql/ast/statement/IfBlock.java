package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.StatementVisitor;

public class IfBlock extends Statement {

	private final Expression condition;
	private final Statements body;
	
	public IfBlock(Expression expression, Statements body) {
		this.condition = expression;
		this.body = body;
	}

	public Expression getCondition() {
		return condition;
	}

	public Statements getBody() {
		return body;
	}

	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
