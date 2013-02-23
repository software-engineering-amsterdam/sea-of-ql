package org.uva.sea.ql.ast.statements.conditions;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public class IfThenElseStatement extends ConditionBlock {
	private final StatementBody _elseBody;
	
	public IfThenElseStatement(Expression condition, StatementBody body, StatementBody elseBody) {
		super(condition, body); _elseBody = elseBody;
	}
	
	public StatementBody getElseBody() {
		return _elseBody;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}