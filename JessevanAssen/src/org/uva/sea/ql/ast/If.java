package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;

public class If implements Statement {
	
	private final Expr condition;
	private final Statement ifBody;
	
	public If(Expr condition, Statement ifBody) {
		this.condition = condition;
		this.ifBody = ifBody;
	}
	
	public Expr getCondition() { return condition; }
	public Statement getIfBody() { return ifBody; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
