package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.literal.Str;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;

public class Question extends Expr implements ASTElement {
	private Str content;
	private Type type;
	private Ident ident;

	public Question(Ident ident, Str content, Type type) {
		this.ident = ident;
		this.content = content;
		this.type = type;
	}

	public Str getContent() {
		return content;
	}

	public Ident getIdent() {
		return ident;
	}

	public Type getType() {
		return type;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

}
