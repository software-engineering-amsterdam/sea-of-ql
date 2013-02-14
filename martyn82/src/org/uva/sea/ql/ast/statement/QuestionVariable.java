package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class QuestionVariable extends QuestionDeclaration {
	private final VarDeclaration varDeclaration;

	public QuestionVariable( StringLiteral label, VarDeclaration varDeclaration ) {
		super( label );
		this.varDeclaration = varDeclaration;
	}

	public VarDeclaration getVarDeclaration() {
		return this.varDeclaration;
	}

	public Type getType() {
		return this.varDeclaration.getType();
	}

	@Override
	public IdentifierExpression getIdentifier() {
		return this.varDeclaration.getIdentifier();
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
