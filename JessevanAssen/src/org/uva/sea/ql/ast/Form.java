package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Identifier;

public class Form {
	
	private final Identifier name;
	private final Statement body;
	
	public Form(Identifier name, Statement body) {
		this.name = name;
		this.body = body;
	}
	
	public Identifier getName() { return name; }
	public Statement getBody() { return body; }
	
	public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
}