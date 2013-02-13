package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.FormNode;
import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class Body implements FormNode {
	private final List<FormElement> formElements;
	private final Location location;
	
	public Body(List<FormElement> formElements, Location location) {
		this.formElements = new ArrayList<>(formElements);
		this.location = location;
	}
	
	public List<FormElement> getElements() {
		return new ArrayList<>(formElements);
	}
	
	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Location getLocation() {
		return location;
	}
	
}
