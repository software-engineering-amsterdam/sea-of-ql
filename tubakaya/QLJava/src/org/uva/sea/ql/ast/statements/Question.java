package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;
import org.uva.sea.ql.ast.types.primitive.StringLiteral;

public class Question extends Statement {

	private Identifier identifier;
	private StringLiteral text;
	private TypeDeclaration type;

	public Question(Identifier identifier, StringLiteral text,
			TypeDeclaration type) {
		this.identifier = identifier;
		this.text = text;
		this.type = type;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public StringLiteral getText() {
		return text;
	}

	public TypeDeclaration getType() {
		return type;
	}
}
