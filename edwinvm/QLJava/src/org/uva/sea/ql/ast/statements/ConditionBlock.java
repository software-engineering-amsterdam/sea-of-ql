package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.FormStatement;

public class ConditionBlock extends FormStatement {
	private final Expr _condition;
	private final FormStatement _ifBody;
	private final FormStatement _elseBody;

	public ConditionBlock(Expr condition, FormStatement ifBody) {
		this(condition, ifBody, null);
	}
	
	public ConditionBlock(Expr condition, FormStatement ifBody, FormStatement elseBody) {
		_condition = condition;
		_ifBody = ifBody;
		_elseBody = elseBody;
	}
	
	public Expr getCondition() {
		return _condition;
	}
	
	public FormStatement getIfBody() {
		return _ifBody;
	}
	
	public FormStatement getElseBody() {
		return _elseBody;
	}
}