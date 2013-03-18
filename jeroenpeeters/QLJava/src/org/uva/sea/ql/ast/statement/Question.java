package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;
import org.uva.sea.ql.ast.type.Type;


public class Question extends Statement {

	private final Identifier ident;
	private final TextLiteral label;
	private final Type type;
	
	public Question(final Identifier ident, final TextLiteral label, final Type type){
		this.ident = ident;
		this.label = label;
		this.type = type;
	}

	public Identifier getIdent() {
		return ident;
	}

	public TextLiteral getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}
	
	public <T> T accept(final StatementVisitor<T> v){
		return v.visit(this);
	}

}
