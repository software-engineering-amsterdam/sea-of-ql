package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;

import org.uva.sea.ql.ast.expressions.Expr;

public abstract class ConditionBlock extends FormStatement {
	private final Expr _condition;
	private final ArrayList<FormStatement> _body;
	
	public ConditionBlock(Expr condition, ArrayList<FormStatement> body) {
		_condition = condition;
		_body = body;
	}
	
	public Expr getCondition() {
		return _condition;
	}
	
	public ArrayList<FormStatement> getBody() {
		return _body;
	}
}