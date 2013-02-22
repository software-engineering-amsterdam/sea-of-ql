package org.uva.sea.ql.ast.statements.conditions;

import java.util.ArrayList;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.ast.statements.FormStatement;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public class IfThenElse extends ConditionBlock {
	private final ArrayList<FormStatement> _elseBody;
	
	public IfThenElse(Expr condition, ArrayList<FormStatement> body, ArrayList<FormStatement> elseBody) {
		super(condition, body); _elseBody = elseBody;
	}
	
	public ArrayList<FormStatement> getElseBody() {
		return _elseBody;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}