package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.visitor.FormVisitor;

public class Question extends AbstractForm {

	private final Ident ident;
	private final Block statements;

	public Question(Ident ident, Block statements) {
		this.ident = ident;
		this.statements = statements;
	}

	public Ident getIdent() {
		return this.ident;
	}

	public Block getStatements() {
		return this.statements;
	}

	@Override
	public void accept(FormVisitor<?> visitor) {
		visitor.visit(this);
	}

}
