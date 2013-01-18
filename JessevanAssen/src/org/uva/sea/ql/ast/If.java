package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;

public class If implements FormElement {
	
	private final Expr condition;
	private final FormElement ifBody;
	private final FormElement elseBody;
	
	public If(Expr condition, FormElement ifBody, FormElement elseBody) {
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
	}
	
	public Expr getCondition() { return condition; }
	public FormElement getIfBody() { return ifBody; }
	public FormElement getElseBody() { return elseBody; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
