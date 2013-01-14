package org.uva.sea.ql.ast;

import org.uva.sea.ql.ASTNodeVisitor;
import org.uva.sea.ql.ast.expr.Ident;

public class Form implements ASTNode {
	
	private final Ident name;
	private final FormElement body;
	
	public Form(Ident name, FormElement body) {
		this.name = name;
		this.body = body;
	}
	
	public Ident getName() { return name; }
	public FormElement getBody() { return body; }
	
	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}