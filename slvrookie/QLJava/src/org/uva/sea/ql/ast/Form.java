package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.visitor.Visitor;

public class Form implements ASTNode {

	private final Ident fID;
	private final List<FormElement> felements;

	public Form(Ident fID, List<FormElement> felements) {
		this.fID = fID;
		this.felements = felements;
	}

	public Ident getfID() {
		return fID;
	}

	public List<FormElement> getfelements() {
		return felements;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

}
