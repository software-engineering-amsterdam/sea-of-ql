package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.visitor.checkers.ElementChecker;

public class Form extends QLProgram{
	private final Ident id;
	private final Body body;

	public Form(Ident id, Body body) {
		this.id = id;
		this.body = body;

	}

	public Ident getId() {
		return id;
	}

	public Body getBody() {
		return body;
	}

	@Override
	public void accept(ElementChecker qlElement) {
			qlElement.visit(this);
	}

	

}
