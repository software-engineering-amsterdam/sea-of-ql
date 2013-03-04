package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.Type;

public class Question extends Statement {

	private Identifier identifier;
	private StringLiteral text;
	private Type type;

	public Question(Identifier identifier, StringLiteral text,
			Type type) {
		this.identifier = identifier;
		this.text = text;
		this.type = type;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public StringLiteral getText() {
		return text;
	}

	public Type getType() {
		return type;
	}
}
