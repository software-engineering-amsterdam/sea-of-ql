package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class Label extends Node {
	private final String identifier;
	
	public Label(final String text) {
		this.identifier = text;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	// Labels with the same identifier are the same
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null || !Label.class.equals(obj.getClass())) {
			return false;
		}
	
		final Label otherLabel = (Label)obj;
		return identifier.equals(otherLabel.getIdentifier());
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
