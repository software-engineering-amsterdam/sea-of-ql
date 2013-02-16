package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Expression;

public class If implements Statement {
	
	private final Expression condition;
	private final Statement ifBody;
	
	public If(Expression condition, Statement ifBody) {
		this.condition = condition;
		this.ifBody = ifBody;
	}
	
	public Expression getCondition() { return condition; }
	public Statement getIfBody() { return ifBody; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
