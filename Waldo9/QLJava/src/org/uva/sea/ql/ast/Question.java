package org.uva.sea.ql.ast;

public class Question extends Statement {
	
	private Ident identifier;
	private StringLiteral label;
	private Type type;
	
	public Question(Ident identifier, StringLiteral label, Type type) {
		this.identifier = identifier;
		this.label = label;
		this.type = type;
	}
	
}
