package org.uva.sea.ql.ast.formelements;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.visitors.IElementVisitor;

public class Form extends FormElement {

	private final Ident name;
	private final Block body;

	public Form(Ident name, Block body) {
		this.name = name;
		this.body = body;
	}

	public Ident getName() {
		return name;
	}

	public Block getBody() {
		return body;
	}

	@Override
	public void accept(IElementVisitor ElementVisitor) {
		ElementVisitor.visit(this);
	}

}
