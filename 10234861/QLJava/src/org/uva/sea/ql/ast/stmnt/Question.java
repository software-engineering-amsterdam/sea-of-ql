package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.type.Type;

public class Question extends Statement {

	private Ident id;
	private StringLiteral label;
	private Type type;

	public Question(Ident id, StringLiteral label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}

	public Ident getID() {
		return id;
	}

	public StringLiteral getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
