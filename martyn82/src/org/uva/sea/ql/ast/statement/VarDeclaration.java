package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class VarDeclaration extends Statement {
	private final IdentifierExpression ident;
	private final Type type;

	public VarDeclaration( IdentifierExpression ident, Type type ) {
		this.ident = ident;
		this.type = type;
	}

	public IdentifierExpression getIdent() {
		return this.ident;
	}

	public Type getType() {
		return this.type;
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
