package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.visitor.IElementVisitor;

public class Body extends QLProgram {

	private final List<BodyElement> body = new ArrayList<BodyElement>();

	public List<BodyElement> getBodyElement() {
		return body;
	}

	public void addElement(BodyElement bodyElement) {
		body.add(bodyElement);
	}

	@Override
	public void accept(IElementVisitor qlElement) {
		qlElement.visit(this);
	}

}
