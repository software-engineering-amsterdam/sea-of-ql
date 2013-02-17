package org.uva.sea.ql.ast;

public class Form extends Node {
	
	public final Identifier id;
	public final Statements statements;
	
	public Form(Identifier id, Statements statements) {
		this.id = id;
		this.statements = statements;
	}
	
}
