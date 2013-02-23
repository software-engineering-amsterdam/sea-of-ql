package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expr;

public abstract class ConditionBlock extends FormStatement {
	private final Expr _condition;
	private final StatementBody _body;
	
	public ConditionBlock(Expr condition, StatementBody body) {
		_condition = condition;
		_body = body;
	}
	
	public Expr getCondition() {
		return _condition;
	}
	
	public StatementBody getBody() {
		return _body;
	}
}