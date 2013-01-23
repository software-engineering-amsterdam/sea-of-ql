package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.Ident;


public class Form implements ASTNode {

	private final Ident fID;
	private final List<FormElement> fBody;

	public Form(Ident fID, List<FormElement> fBody) {
		this.fID = fID;
		this.fBody = fBody;
	}

	public Ident getFormID() {
		return fID;
	}

	public List<FormElement> getFormBody() {
		return fBody;
	}

}
