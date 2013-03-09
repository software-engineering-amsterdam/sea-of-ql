package org.uva.sea.ql.ast.form;
import java.util.List;

import org.uva.sea.ql.Questionnaire;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class Form implements Questionnaire, ASTNode {
	protected String name;
	protected List<FormElement> elements;
	
	public Form(String name, List<FormElement> elements) {
		this.name     = name;
		this.elements = elements;
	}
	
	public List<FormElement> getElements() {
		return elements;
	}

	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}

	@Override
	public String getName() {
		return name;
	}
}
