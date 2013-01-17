package org.uva.sea.ql.ast.type;

import java.util.List;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.statement.*;

public class Form extends Type{
	
	private final List<Statement> statements; 
	private final Ident ident; 
	
	public Form(Ident ident, List<Statement> statements){
		this.ident = ident;
		this.statements = statements;
	}

	public Ident getIdent() {
		return ident;
	}

	public List<Statement> getStatements() {
		return statements;
	}
	
}
