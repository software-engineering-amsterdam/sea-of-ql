package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.visitor.TypeChecker;

public class Form extends FormElement {

	private final Ident fID;
	private final Block fBody;

	public Form(Ident fID, Block fBody) {
		this.fID = fID;
		this.fBody = fBody;
	}

	public Ident getFormID() {
		return fID;
	}

	public Block getFormBody() {
		return fBody;
	}

	@Override
	public void accept(TypeChecker visitor) {
		visitor.visit(this);
	}

}
