package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expression;

public abstract class ConditionBlock extends FormStatement {
	private final Expression _condition;
	private final StatementBody _body;
	
	public ConditionBlock(Expression condition, StatementBody body) {
		_condition = condition;
		_body = body;
	}
	
	public Expression getCondition() {
		return _condition;
	}
	
	public StatementBody getBody() {
		return _body;
	}
}