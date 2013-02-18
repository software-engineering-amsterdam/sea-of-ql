package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.FormStatement;

public abstract class ConditionBlock extends FormStatement {
	private final Expr _condition;
	
	public ConditionBlock(Expr condition) {
		_condition = condition;
	}
	
	public Expr getCondition() {
		return _condition;
	}
}