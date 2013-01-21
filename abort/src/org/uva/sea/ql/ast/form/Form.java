package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents a form (as defined in the QL language).
 * @author J. Dijkstra
 *
 */
public class Form extends Node {
	/**
	 * Form name.
	 */
	private final String name;
	/**
	 * The elements the form consists of.
	 */
	private final List<Element> nodes;
	
	/**
	 * Constructor.
	 * @param name form name
	 * @param nodes elements that are part of the form
	 */
	public Form(final String name, final List<Element> nodes) {
		this.name = name;
		this.nodes = nodes;
	}

	@Override
	public void accept(final IVisitor visitor) {
		for (final Node nodeToVisit : nodes) {
			nodeToVisit.accept(visitor);
		}
		
		visitor.visit(this);
	}

	/**
	 * Retrieve the nodes/elements the form consists of.
	 * @return form elements
	 */
	public final List<Element> getNodes() {
		return nodes;
	}
	
	/**
	 * Retrieve the form name.
	 * @return form name
	 */
	public String getName() {
		return name;
	}
}
