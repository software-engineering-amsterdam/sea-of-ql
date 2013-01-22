package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.Type;

public class Question extends Statement {
	
	private Ident identifier;
	private StringLiteral stringLiteral;
	private Type type;
	
	public Question(Ident identifier, StringLiteral stringLiteral, Type type) {
		this.identifier = identifier;
		this.stringLiteral = stringLiteral;
		this.type = type;
	}
	
	public Ident getIdentifier() {
		return identifier;
	}
	
	public StringLiteral getStringLiteral() {
		return stringLiteral;
	}
	
	public Type getType() {
		return type;
	}
	
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		return visitor.visit(this);
    }
	
}
