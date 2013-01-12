package org.uva.sea.ql.ast;

import java.util.List;

public class Form implements ASTNode {
	
	private final Ident name;
	private final List<FormElement> body;
	
	public Form(Ident name, List<FormElement> body) {
		this.name = name;
		this.body = body;
	}
	
	public Ident getName() { return name; }
	public List<FormElement> getBody() { return body; }
}