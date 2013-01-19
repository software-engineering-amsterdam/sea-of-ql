package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.visitor.Visitor;

public class Form implements ASTNode {

	private final Ident fID;
	private final FormBlock fBody;

	public Form(Ident fID, FormBlock fBody) {
		this.fID = fID;
		this.fBody = fBody;
	}

	public Ident getFormID() {
		return fID;
	}

	public FormBlock getFormBody() {
		return fBody;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}
