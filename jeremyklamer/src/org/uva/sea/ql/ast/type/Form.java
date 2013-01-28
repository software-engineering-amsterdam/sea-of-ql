package org.uva.sea.ql.ast.type;

import java.util.List;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.statement.*;

public class Form extends Type{
	
	private final List<Statement> body; 
	private final Ident name; 
	
	public Form(Ident name, List<Statement> body){
		this.name = name;
		this.body = body;
	}

	public Ident getName() {
		return name;
	}

	public List<Statement> getBody() {
		return body;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		// TODO Check if FORM belongs here or somewhere else...
		return false;
	}
	
}
