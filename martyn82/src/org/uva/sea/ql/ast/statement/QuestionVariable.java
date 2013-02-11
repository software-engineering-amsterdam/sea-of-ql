package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class QuestionVariable extends QuestionDeclaration {
	private final VarDeclaration varDeclaration;

	public QuestionVariable( Str label, VarDeclaration varDeclaration ) {
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
	public Ident getIdent() {
		return this.varDeclaration.getIdent();
	}

	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
