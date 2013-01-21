package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorException;

public class Question extends Expr implements ASTElement {
	private StringLiteral content;
	private Type type;
	private Ident ident;

	public Question(Ident ident, StringLiteral content, Type type) {
		this.ident = ident;
		this.content = content;
		this.type = type;
	}

	public StringLiteral getContent() {
		return content;
	}

	public Ident getIdent() {
		return ident;
	}

	public Type getType() {
		return type;
	}

	@Override
	public void accept(ASTVisitor visitor) throws VisitorException {
		visitor.visit(this);
	}

}
