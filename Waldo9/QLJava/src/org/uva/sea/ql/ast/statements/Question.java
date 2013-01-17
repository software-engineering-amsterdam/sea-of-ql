package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;

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
