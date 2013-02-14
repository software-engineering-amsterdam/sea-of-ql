package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class VariableDeclaration extends Statement {
	private final IdentifierExpression identifier;
	private final Type type;

	public VariableDeclaration( IdentifierExpression identifier, Type type ) {
		this.identifier = identifier;
		this.type = type;
	}

	public IdentifierExpression getIdentifier() {
		return this.identifier;
	}

	public Type getType() {
		return this.type;
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
