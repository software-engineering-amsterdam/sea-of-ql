package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.visitor.TypeChecker;

public class Form extends FormElement {

	private final Ident name;
	private final Block body;

	public Form(Ident name, Block body) {
		this.name = name;
		this.body = body;
	}

	public Ident getFormName() {
		return name;
	}

	public Block getFormBody() {
		return body;
	}

	@Override
	public void accept(TypeChecker visitor) {
		visitor.visit(this);
	}

}
