package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;

public class If implements FormElement {
	
	private final Expr condition;
	private final FormElement ifBody;
	
	public If(Expr condition, FormElement ifBody) {
		this.condition = condition;
		this.ifBody = ifBody;
	}
	
	public Expr getCondition() { return condition; }
	public FormElement getIfBody() { return ifBody; }

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}	
}
