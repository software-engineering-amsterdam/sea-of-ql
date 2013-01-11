package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.Visitor;
import org.uva.sea.ql.ast.expr.Ident;

public class Form implements ASTNode {
	
	private final Ident name;
	private final List<FormElement> body;
	
	public Form(Ident name, List<FormElement> body) {
		this.name = name;
		this.body = body;
	}
	
	public Ident getName() { return name; }
	public List<FormElement> getBody() { return body; }
	
	@Override
	public <ReturnType, ParameterType> ReturnType accept(Visitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}