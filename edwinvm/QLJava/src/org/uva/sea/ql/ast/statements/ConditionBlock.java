package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;

public class ConditionBlock extends FormStatement {
	private final Expr _expr;
	private final FormStatement _ifBody;
	private final FormStatement _elseBody;

	public ConditionBlock(Expr condition, FormStatement ifBody) {
		this(condition, ifBody, null);
	}
	
	public ConditionBlock(Expr expr, FormStatement ifBody, FormStatement elseBody) {
		_expr = expr;
		_ifBody = ifBody;
		_elseBody = elseBody;
	}
	
	public Expr getExpr() {
		return _expr;
	}
	
	public FormStatement getIfBody() {
		return _ifBody;
	}
	
	public FormStatement getElseBody() {
		return _elseBody;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}