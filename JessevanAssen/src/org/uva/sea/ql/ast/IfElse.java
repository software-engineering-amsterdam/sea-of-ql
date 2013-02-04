package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;

public class IfElse implements Statement {

	private final Expr condition;
	private final Statement ifBody;
	private final Statement elseBody;

	public IfElse(Expr condition, Statement ifBody, Statement elseBody) {
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
	}
	
	public Expr getCondition() { return condition; }
	public Statement getIfBody() { return ifBody; }
	public Statement getElseBody() { return elseBody; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
