package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;

public class Form {
	
	private final Ident name;
	private final Statement body;
	
	public Form(Ident name, Statement body) {
		this.name = name;
		this.body = body;
	}
	
	public Ident getName() { return name; }
	public Statement getBody() { return body; }
	
	public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}