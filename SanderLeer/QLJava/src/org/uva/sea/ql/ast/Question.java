package org.uva.sea.ql.ast;

public class Question implements ASTNode {
	private final Identifier identifier;
	private final StringValue label;
	private final Datatype datatype;
	
	public Question(Identifier identifier, StringValue label, Datatype datatype) {
		this.identifier = identifier;
		this.label = label;
		this.datatype = datatype;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public StringValue getLabel() {
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
