package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.FormNode;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class Body implements FormNode {
	private final List<FormElement> formElements;
	
	public Body(List<FormElement> formElements) {
		this.formElements = new ArrayList<>(formElements);
	}
	
	public List<FormElement> getElements() {
		return new ArrayList<>(formElements);
	}
	
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
