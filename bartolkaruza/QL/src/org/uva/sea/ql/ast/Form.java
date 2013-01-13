package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Form implements ASTNode {
	
	private String label;
	private Questions questions;
	
	public Form (String label, Questions questions) {
		this.setLabel(label);
		this.questions = questions;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		questions.accept(visitor);
		visitor.visit(this);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
