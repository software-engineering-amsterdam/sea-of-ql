package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class Form extends Node {
	private final List<Element> nodes;
	
	public Form(final List<Element> nodes) {
		this.nodes = nodes;
	}

	@Override
	public void accept(final IVisitor visitor) {
		for (final Node nodeToVisit : nodes) {
			nodeToVisit.accept(visitor);
		}
		
		visitor.visit(this);
	}

	public final List<Element> getNodes() {
		return nodes;
	}
}
