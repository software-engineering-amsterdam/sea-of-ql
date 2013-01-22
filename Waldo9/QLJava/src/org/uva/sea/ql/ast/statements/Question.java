package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.Type;

public class Question extends Statement {
	
	private final Ident variable;
	private final StringLiteral label;
	private final Type type;
	
	public Question(Ident identifier, StringLiteral stringLiteral, Type type) {
		this.variable = identifier;
		this.label = stringLiteral;
		this.type = type;
	}
	
	public Ident getVariable() {
		return variable;
	}
	
	public StringLiteral getLabel() {
		return label;
	}
	
	public Type getType() {
		return type;
	}
	
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		return visitor.visit(this);
    }
	
}
