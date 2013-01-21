package org.uva.sea.ql.ast;

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
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
