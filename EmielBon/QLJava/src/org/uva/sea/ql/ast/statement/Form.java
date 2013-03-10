package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Identifier;

/**
 * Represents the top-level Form construct in the QL language
 */
public class Form extends Statement {
	
	private final Identifier id;
	private final Statements body;
	
	public Form(Identifier id, Statements body) {
		this.id = id;
		this.body = body;
	}

	/**
	 * Returns this form's identifier
	 * @return The identifier
	 */
	public Identifier getIdentifier() {
		return id;
	}

	/**
	 * Returns the statements inside the body of this form
	 * @return A Statements object containing all the statements inside this form
	 */
	public Statements getBody() {
		return body;
	}

	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
