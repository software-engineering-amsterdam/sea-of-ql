package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.visitor.StatementVisitor;

public class FormDeclaration extends Statement {
	private final String label;
	private final Statements body;

	public FormDeclaration( String label, Statements body ) {
		assert ( label != null ) && ( label != "" ) && ( body != null );

		this.label = label;
		this.body = body;
	}

	public Statements getBody() {
		return this.body;
	}

	public String getLabel() {
		return this.label;
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
