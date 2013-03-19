package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

public class Question extends Statement {

	private final Identifier id;
	private final StringLiteral label;
	private final Type type;
	
	public Question(Identifier id, StringLiteral label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}

	public Identifier getIdentifier() {
		return id;
	}
	
	public StringLiteral getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}
	
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

}