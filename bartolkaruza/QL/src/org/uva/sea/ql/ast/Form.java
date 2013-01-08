package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Form implements ASTNode {
	
	private String label;
	
	public Form (String label) {
		this.setLabel(label);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void walkChild(ASTNode parent) {
		
	}
}
