package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;

public class Question extends Statement {
	private final Identifier identifier;
	private final StringLiteral label;
	private final Datatype datatype;
	
	public Question(Identifier identifier, StringLiteral label, Datatype datatype) {
		this.identifier = identifier;
		this.label = label;
		this.datatype = datatype;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public StringLiteral getLabel() {
		return label;
	}

	public Datatype getDatatype() {
		return datatype;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
