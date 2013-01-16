package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.visitor.Visitor;

public class Form implements ASTNode {

	private final Ident fID;
	private final FormBlock fbody;

	public Form(Ident fID, FormBlock fbody) {
		this.fID = fID;
		this.fbody = fbody;
	}

	public Ident getfID() {
		return fID;
	}

	public FormBlock getfBody() {
		return fbody;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}
