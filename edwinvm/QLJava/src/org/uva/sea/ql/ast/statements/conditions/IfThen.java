package org.uva.sea.ql.ast.statements.conditions;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public class IfThen extends ConditionBlock {
	public IfThen(Expr condition, FormStatement body) {
		super(condition, body);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}