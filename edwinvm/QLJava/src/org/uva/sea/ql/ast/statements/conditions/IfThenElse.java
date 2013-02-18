package org.uva.sea.ql.ast.statements.conditions;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public class IfThenElse extends ConditionBlock {
	private final FormStatement _body;
	private final FormStatement _elseBody;
	
	public IfThenElse(Expr condition, FormStatement body, FormStatement elseBody) {
		super(condition);
		_body = body;
		_elseBody = elseBody;
	}
	
	public FormStatement getBody() {
		return _body;
	}
	
	public FormStatement getElseBody() {
		return _elseBody;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}