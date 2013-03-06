package org.uva.sea.ql.ast.form;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class Form implements ASTNode {
	
	protected List<FormElement> elements;
	
	public Form(List<FormElement> elements) {
		this.elements = elements;
	}
	
	public List<FormElement> getElements() {
		return elements;
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}
}
