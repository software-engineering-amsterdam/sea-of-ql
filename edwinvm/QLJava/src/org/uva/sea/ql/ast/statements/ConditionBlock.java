package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.FormStatement;

public abstract class ConditionBlock extends FormStatement {
	private final Expr _condition;
	private final FormStatement _body;
	
	public ConditionBlock(Expr condition, FormStatement body) {
		_condition = condition;
		_body = body;
	}
	
	public Expr getCondition() {
		return _condition;
	}
	
	public FormStatement getBody() {
		return _body;
	}
}