package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

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

	@Override
	public void accept(Visitor visitor, Context context) {
		visitor.visit(this, context);

	}


}
