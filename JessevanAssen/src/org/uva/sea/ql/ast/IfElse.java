package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Expression;

public class IfElse implements Statement {

	private final Expression condition;
	private final Statement ifBody;
	private final Statement elseBody;

	public IfElse(Expression condition, Statement ifBody, Statement elseBody) {
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
	}
	
	public Expression getCondition() { return condition; }
	public Statement getIfBody() { return ifBody; }
	public Statement getElseBody() { return elseBody; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
