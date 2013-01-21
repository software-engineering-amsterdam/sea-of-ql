package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;

public class Question extends Statement {
	private final Ident ident;
	private final StringLiteral strLtr;
	private final Type type;

	public Question(Ident ident, StringLiteral strLtr, Type type) {
		this.ident = ident;
		this.strLtr = strLtr;
		this.type = type;
	}
	
	public Ident getIdent() {
		return ident;
	}
	
	public StringLiteral getStrLtr() {
		return strLtr;
	}
	
	public Type getType() {
		return type;
	}
}